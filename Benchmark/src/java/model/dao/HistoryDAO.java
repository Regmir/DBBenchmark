/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

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
}
