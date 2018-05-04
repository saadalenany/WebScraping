/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebscraping;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.math.BigDecimal;

/**
 *
 * @author Saad Alenany
 */
@DatabaseTable(tableName = "product")
public class Product {

    @DatabaseField(id = true,columnName = "id")
    private int id;
    @DatabaseField(columnName = "title")
    private String title ;
    @DatabaseField(columnName = "price")
    private BigDecimal price ;
    @DatabaseField(columnName = "url")
    private String url ;

    public Product() {
    }

    public Product(int id, String title, BigDecimal price, String url) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title=" + title + ", price=" + price + ", url=" + url + '}';
    }

}
