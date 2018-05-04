/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebscraping;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.net.URLEncoder;

/**
 *
 * @author Saad Alenany
 */
public class JavaWebScraper {

    public static void main(String[] args) {
        String searchQuery = "Iphone 6s";

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = "https://www.amazon.com/gp/goldbox" /* + URLEncoder.encode(searchQuery, "UTF-8")*/;
            HtmlPage page = client.getPage(searchUrl);

            System.out.println(page.asText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
