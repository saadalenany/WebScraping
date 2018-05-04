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
import java.util.ArrayList;
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
    Dao<Product, Integer> productDao;

    public DBDao() {
        try {
            Class.forName("org.h2.Driver");
            connectionSource = new JdbcConnectionSource(databaseUrl);

            productDao = DaoManager.createDao(connectionSource, Product.class);
            TableUtils.createTableIfNotExists(connectionSource, Product.class);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(Product p) {
        try {
            //a simple insert to the table
            productDao.create(p);
        } catch (SQLException ex) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = null;
        try {
            //a simple queryForAll rows in the table
            products = (ArrayList<Product>) productDao.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(DBDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
