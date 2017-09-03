/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Utility.QueryTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class DirectConnectionDAO {
    public static void Execute(String query, QueryTime qt) throws ClassNotFoundException, SQLException{
        Statement statement = null;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "admin");
        statement = connection.createStatement();
        long st = System.nanoTime();
            statement.execute(query);
        long end = System.nanoTime();
        qt.setAverage(end-st);
        qt.setMin(end-st);
        qt.setMax(end-st);
        qt.setTotal(end-st);
    }
    
}
