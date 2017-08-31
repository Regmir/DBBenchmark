/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Date;
import java.util.List;
import model.pojo.History;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Acer
 */
public class HistoryDAO {
    public static List<History> Select(){
        List<History> list = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM History";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
    }
    
    public static void Insert(String type, int num, double avg, double min,
            double max, double total, Date date, String custq, String user) 
    {   
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
        History newobj = new History();
        newobj.setType(type);
        newobj.setNumber(num);
        newobj.setAvg(avg);
        newobj.setMin(min);
        newobj.setMax(max);
        newobj.setTotal(total);
        newobj.setDate(date);
        newobj.setCustomQuery(custq);
        newobj.setDbusername(user);
        newobj.setID(10);
        session.save(newobj);
        session.getTransaction().commit();
        session.close();
    }
}
