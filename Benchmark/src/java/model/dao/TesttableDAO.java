/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

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
        
    public static void Insert(String newdata) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Testtable newobj = new Testtable();
        newobj.setRandomdata(newdata);
        session.save(newobj);
        session.getTransaction().commit();
        session.close();
    }
    
    public static void Delete(short id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Testtable delobj = new Testtable();
        delobj.setId(id);
        session.delete(delobj);
        session.getTransaction().commit();
        session.close();
    }
}
