/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Utility.UserStorage;
import java.util.Date;
import java.util.List;
import model.pojo.History;
import model.pojo.Usersstorage;
import model.util.HibernateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Acer
 */
public class UsersstorageDAO {
    public static List<Usersstorage> Select(){
        List<Usersstorage> list = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usersstorage";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
    }
    
    public static void Insert(String log, String pas, String email, int level) 
    {   
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); 
        Usersstorage newobj = new Usersstorage();
        newobj.DBUserName(log);
        newobj.setDBUserPas(pas);
        newobj.setDBUserEmail(email);
        newobj.setAccessLevel(level);
        session.save(newobj);
        session.getTransaction().commit();
        session.close();
    }
    public static boolean LogExisting(String login){
        boolean result=false;
        List<History> list = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Usersstorage where DBUserName = :paramName";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", login);
        list = query.list();
        session.close();
        if(list.size()>0) result=true;
        return result;
    }
    public static boolean PassCheck(String login,String password){
        boolean result=false;
        List<Usersstorage> list = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Usersstorage where DBUserName = :paramName and DBUserPas = :param2Name";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", login);
        String HashedPas;
        HashedPas = DigestUtils.md5Hex(password);
        query.setParameter("param2Name", HashedPas);
        list = query.list();
        session.close();
        if(list.size()>0) {
            result=true;
            UserStorage.setLevel(list.get(0).getAccessLevel());
        }
        return result;
    }
}
