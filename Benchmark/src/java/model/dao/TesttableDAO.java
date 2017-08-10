/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Utility.QueryTime;
import java.util.List;
import model.pojo.Testtable;
import model.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Acer
 */
public class TesttableDAO {
    public static List<Testtable> Select(){
        List<Testtable> list = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Testtable";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
    }
        
    public static void Update(short id, String newdata){
        /*Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "UPDATE Testtable set randomdata = :newdata "  + 
        "WHERE id = :newid";
        Query query = session.createQuery(hql);
        query.setParameter("newdata", newdata);
        query.setParameter("newid", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();*/
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Testtable newobj = new Testtable();
        newobj.setRandomdata(newdata);
        newobj.setId(id);
        session.update(newobj);
        session.getTransaction().commit();
        session.close();
    }
        
    public static void Insert(Integer number, QueryTime qt) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Integer maxid=Select().size();
        Testtable newobj = new Testtable();
        newobj.setRandomdata("RD"+maxid.toString());
        long st = System.nanoTime();
            session.save(newobj);
        long end = System.nanoTime();
        long total=end-st;
        qt.setMax(end-st);
        qt.setMin(end-st);
        for (int i=maxid+1;i<=number+maxid-1;i++){
            newobj = new Testtable();
            newobj.setRandomdata("RD"+String.valueOf(i));
            st = System.nanoTime();
                session.save(newobj);
            end = System.nanoTime();
            if(end-st<qt.getMin()) qt.setMin(end-st);
            if(end-st>qt.getMax()) qt.setMax(end-st);
            total+=end-st;
        }
        qt.setAverage(total/number);
        qt.setTotal(total);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void Delete(Integer number, QueryTime qt){
        List<Testtable> list=Select();
        int maxid=list.size();
        QueryTime fillerQt=new QueryTime();
        if(number>maxid)
            Insert(number-maxid,fillerQt);
        list=Select();
        maxid=list.get(list.size()-1).getId();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Testtable delobj = new Testtable();
        delobj.setId((short)maxid);
        long st = System.nanoTime();
            session.delete(delobj);
        long end = System.nanoTime();
        long total=end-st;
        qt.setMax(end-st);
        qt.setMin(end-st);
        for (int i=1;i<number;i++){
            maxid=list.get(list.size()-1-i).getId();
            delobj = new Testtable();
            delobj.setId((short)maxid);
            st = System.nanoTime();
                session.delete(delobj);
            end = System.nanoTime();
            if(end-st<qt.getMin()) qt.setMin(end-st);
            if(end-st>qt.getMax()) qt.setMax(end-st);
            total+=end-st;
            //maxid=list.get(list.size()-i-2).getId();
        }
        qt.setAverage(total/number);
        qt.setTotal(total);
        session.getTransaction().commit();
        session.close();
    }
}
