/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebscraping;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saad Alenany
 */
public class DBDao {
// this uses h2 but you can change it to match your database

    String databaseUrl = "jdbc:h2:~/test";
// create a connection source to our database
    ConnectionSource connectionSource;

    public void start(){
        try {

            Class.forName("org.h2.Driver");
            connectionSource = new JdbcConnectionSource(databaseUrl);

            Dao<Product,Integer> productDao = DaoManager.createDao(connectionSource, Product.class);
            TableUtils.createTableIfNotExists(connectionSource, Product.class);

            //a simple insert to the table
//            Product p = new Product(1, databaseUrl, BigDecimal.ONE, databaseUrl);
//            productDao.create(p);

            //a sample of clearing the table
//            TableUtils.clearTable(connectionSource, Product.class);

            //a simple queryForAll rows in the table
            List<Product> products = productDao.queryForAll();
            System.out.println(products.toString());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new DBDao().start();
    }

}
