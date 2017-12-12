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
public class Javafall2017 
{
    
    public static void main(String[] args) 
    {
        Javafall2017 app = new Javafall2017();
        app.run();
    }
     
    private Connection connection = null;
     
    public Connection getConnection(){
        String url = "jdbc:sqlite:C:\\Users\\boyse\\Documents\\NetBeansProjects\\Javafall2017final.db";
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
                
                createNewTable();
            }
            else
            {
                System.out.println("Connected");
            }
        } catch (SQLException e){
            Logger.getLogger(Javafall2017.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     
      public void createNewTable() 
      {
        String sql = "CREATE TABLE IF NOT EXISTS inventory(\n"
                + "name string NOT NULL,\n"
                + "amount int, \n"
                + "price int \n"
                + ");";
        
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e){
            Logger.getLogger(Javafall2017.class.getName()).log(Level.SEVERE, null, e);
        }
    }
      
    /*public void Sort()
    {
        String sql = "SELECT * FROM inventory ORDER BY name ASC";
        //String sql2 = "UPDATE inventory SET (name, amount, price) VALUES(?,?,?)";
        try (Connection connection = getConnection()/*; PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            //Statement statement = connection.createStatement();
            //ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next())
            {
                System.out.println("Item Name: " + rs.getString("name") + "\t"
                        + "Quantity: " + rs.getInt("amount") + "\t"
                        + "Price: " + rs.getInt("amount")*rs.getInt("price"));
            }
            //pstmt.execute();
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }        
    }*/
      
    public void Insert(String _name, int _amount, int _price) 
    {
        if(Contains(_name) == false)
        {
            String sql = "INSERT INTO inventory(name, amount, price) VALUES(?,?,?)";
 
            try (Connection connection = getConnection();
                    PreparedStatement pstmt = connection.prepareStatement(sql)) 
                    {
                        pstmt.setString(1, _name);
                        pstmt.setInt(2, _amount);
                        pstmt.setInt(3, _price);
                        pstmt.executeUpdate();
                        System.out.println("\nAdded -- Item Name: " + _name + "\tQuantity: " + _amount + "\tValue: " + _price);
                    } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    } 
    
    public void Delete(String _name)
    {
        if(Contains(_name) == true)
        {
            String sql = "DELETE FROM inventory WHERE name = ?";
 
            try (Connection connection = getConnection();
                    PreparedStatement pstmt = connection.prepareStatement(sql)) 
                    {
                        pstmt.setString(1, _name);
                        pstmt.executeUpdate();
                        System.out.println("Deleted -- Item Name: " + _name);
                    } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void UpdateQuantity(String _name, int _amount)
    {
        String sql = "UPDATE inventory SET amount = (amount +'" + _amount + "')" + " WHERE name ='" + _name+"'";
        
        try (Connection connection = getConnection())
        {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,_name);
            pstmt.setInt(2, _amount);
            pstmt.execute();
            //ResultSet rs = pstmt.executeQuery();
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public int GetQuantity(String _name)
    {
        String sql = "SELECT amount FROM inventory WHERE name = '" + _name + "'";
        int temp72;
        try (Connection connection = getConnection())
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            temp72 = rs.getInt("amount");
            return temp72;
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public void FindAndPrint(String _name)
    {
        String sql = "SELECT * FROM inventory WHERE name = '" + _name + "'" ;
        try (Connection connection = getConnection())
        {
            //PreparedStatement pstmt = connection.prepareStatement(sql);
            Statement statement = connection.createStatement();
            //pstmt.setString(1, _name);
            ResultSet rs = statement.executeQuery(sql);
            //String name = rs.getString(_name);
            System.out.println("Item Name: " + rs.getString("name") + "\t"
                        + "Quantity: " + rs.getInt("amount") + "\t"
                        + "Price: " + rs.getInt("amount")*rs.getInt("price"));
        }
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean Contains(String _name)
    {
        String sql = "SELECT name FROM inventory";

        try (Connection connection = getConnection())
        {
            Statement statement = connection.createStatement();
            ResultSet rsN = statement.executeQuery(sql);

            while(rsN.next())
            {
                if(rsN.getString("name").equals(_name))
                {
                    return true;
                }
            }
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
      
      public void PrintTable()
      {
        String sql = "SELECT name, amount, price FROM inventory";
        try (Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("Item Name: " + resultSet.getString("name") + "\t"
                        + "Quantity: " + resultSet.getInt("amount") + "\t"
                        + "Price: " + resultSet.getInt("amount")*resultSet.getInt("price"));
            }
        } catch (SQLException e){
            Logger.getLogger(Javafall2017.class.getName()).log(Level.SEVERE, null, e);
        }
      }
      
    public void run()
    {
        boolean flag = false;
        String name, temp,  temp3;
        int amount, price, temp4;
        Scanner in = new Scanner(System.in);
        
        createNewDatabase();
        
        System.out.println("\nWelcome to the inventory\nIf you have any questions type 'help'");
        while(flag == false)
        {
            System.out.println("\nWhat would you like to do?");
            temp = in.nextLine();
            switch(temp)
            {
                case "kill": flag = true;
                    break;
                case "end": flag = true;
                    break;
                case "stop": flag = true;
                    break;
                case "quit": flag = true;
                    break;
                
                case "insert": 
                    System.out.println("\nWhat is the name of the item you wish to insert?");
                    name = in.nextLine();
                    System.out.println("\nHow many of that item?");
                    amount = in.nextInt();
                    boolean temp2 = Contains(name);
                    if(temp2 == false)
                    {
                        System.out.println("\nWhat is the value of the item you wish to insert?");
                        price = in.nextInt();
                        Insert(name, amount, price);
                        in.nextLine();
                    }
                    else
                    {
                        UpdateQuantity(name, amount);
                        System.out.println("\nUpdated -- Item Name: " + name);
                        in.nextLine();
                    }
                    break;
                  
                case "delete":
                    System.out.println("\nWhat is the name of the item you wish to delete?");
                    name = in.nextLine();
                    
                    System.out.println("\nDo you want to delete all or some of that item? (all / some)");
                    temp3 = in.nextLine();
                    
                    if(temp3.equals("all"))
                    {
                        Delete(name);
                    }
                    else if(temp3.equals("some"))
                    {
                        System.out.println("\nHow many do you want to delete of that item?\nThere are " + GetQuantity(name) + " currently left");
                        temp4 = in.nextInt();
                        UpdateQuantity(name, -temp4);
                        System.out.println("\nYou deleted " + temp4 + " " + name + "/s");
                        in.nextLine();
                    }
                    break;
                
                case "find":
                    System.out.println("What name would you like to look up?");
                    name = in.nextLine();
                    boolean temp68 = Contains(name);
                    if(temp68 == true)
                    {
                        FindAndPrint(name);
                    }
                    break;
                    
                case "help":
                    System.out.println("print, find, delete, insert");
                    break;
                    
                case "print":
                    PrintTable();
                    break;
                
                default: 
                    System.out.println("I don't understand the command...");
                    break;
            }
        }
        System.out.println("Terminated");
    }
}