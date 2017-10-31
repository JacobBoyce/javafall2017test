/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author Jacob
 */
public class Javafall2017 {

     public static void main(String[] args) 
     {
        Javafall2017 app = new Javafall2017();
        app.run();
    }
     
    private Connection connection = null;
     
    public Connection getConnection(){
        String url = "jdbc:sqlite:C:\\Users\\boyse\\Documents\\NetBeansProjects\\Javafall2017.db";
        try{
            connection = DriverManager.getConnection(url);
        } catch (SQLException e){
            Logger.getLogger(Javafall2017.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
      
    public void createNewDatabase(){
        try (Connection connection = getConnection()){
            if (connection != null){
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("Connection has been established.");
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e){
            Logger.getLogger(Javafall2017.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     
      public void createNewTable() 
      {
        String sql = "CREATE TABLE IF NOT EXISTS candyBag(\n"
                + "candyName string NOT NULL,\n"
                + "candyAmount int"
                + ");";
        
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table was created successfully.");
        } catch (SQLException e){
            Logger.getLogger(Javafall2017.class.getName()).log(Level.SEVERE, null, e);
        }
    }
      
      public void insert(String _candyName, int _candyAmount) 
      {
        String sql = "INSERT INTO candyBag(candyName,candyAmount) VALUES(?,?)";
 
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) 
                {
                    pstmt.setString(1, _candyName);
                    pstmt.setInt(2, _candyAmount);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
      
      public void PrintTable(){
        String sql = "SELECT candyName, candyAmount FROM candyBag";
        try (Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()){
                System.out.println(resultSet.getString("candyName") + "\t"
                        + resultSet.getInt("candyAmount"));
            }
        } catch (SQLException e){
            Logger.getLogger(Javafall2017.class.getName()).log(Level.SEVERE, null, e);
        }
    }
      
      public void run()
      {
        createNewDatabase();
        createNewTable();
        insert("Milky way", 23);
        insert("Skittles", 12);
        insert("Twix", 43);
        PrintTable();
      }
}