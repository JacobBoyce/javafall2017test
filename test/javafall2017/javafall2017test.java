/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017;

import javafall2017.Javafall2017;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacob
 */
public class javafall2017test {
    
    public javafall2017test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void CreateNewDatabaseTest() {
        Javafall2017 app = new Javafall2017();
        app.createNewDatabase();
    }
    
    @Test
    public void CreateNewTableTest() {
        Javafall2017 app = new Javafall2017();
        app.createNewTable();
    }
    
    @Test
    public void InsertTest() {
        Javafall2017 app = new Javafall2017();
        app.insert("sour patch", 5);
        app.PrintTable();
    }
}
