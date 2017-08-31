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
    
    public static void SelectWithTiming(Integer number, QueryTime qt){
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Testtable";       
        long st = System.nanoTime();
            session.createQuery(hql);            
        long end = System.nanoTime();
        qt.setMax(end-st);
        qt.setMin(end-st);
        long total=end-st;
        for (int i=1;i<=number;i++){
            st = System.nanoTime();
                session.createQuery(hql); 
            end = System.nanoTime();
            if(end-st<qt.getMin()) qt.setMin(end-st);
            if(end-st>qt.getMax()) qt.setMax(end-st);
            total+=end-st;
        }
        qt.setAverage(total/number);
        qt.setTotal(total);
        session.close();
    }
        
    public static void Update(Integer number, QueryTime qt){
        List<Testtable> list=Select();
        int maxid=list.size();
        QueryTime fillerQt=new QueryTime();
        if(number>maxid)
            Insert(number-maxid,fillerQt);
        list=Select();
        maxid=list.get(list.size()-1).getId();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Testtable updobj = new Testtable();
        updobj.setId(maxid);
        updobj.setRandomdata("NewRD");
        long st = System.nanoTime();
            session.update(updobj);
        long end = System.nanoTime();
        long total=end-st;
        qt.setMax(end-st);
        qt.setMin(end-st);
        for (int i=1;i<number;i++){
            maxid=list.get(list.size()-1-i).getId();
            updobj = new Testtable();
            updobj.setId(maxid);
            updobj.setRandomdata("NewRD");
            st = System.nanoTime();
                session.update(updobj);
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
    
        
    public static void Insert(Integer number, QueryTime qt) 
    {   
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Integer maxid=Select().size();
        List<Testtable> list1=Select();
        if(number+maxid>200001){
            Testtable delobj = new Testtable();
            delobj.setId(maxid);
            for (int i=0;i<maxid;i++){
                maxid=list1.get(list1.size()-1-i).getId();
                delobj = new Testtable();
                delobj.setId(maxid);
                session.delete(delobj);
            }
        }
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
        delobj.setId(maxid);
        long st = System.nanoTime();
            session.delete(delobj);
        long end = System.nanoTime();
        long total=end-st;
        qt.setMax(end-st);
        qt.setMin(end-st);
        for (int i=1;i<number;i++){
            maxid=list.get(list.size()-1-i).getId();
            delobj = new Testtable();
            delobj.setId(maxid);
            st = System.nanoTime();
                session.delete(delobj);
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
}
