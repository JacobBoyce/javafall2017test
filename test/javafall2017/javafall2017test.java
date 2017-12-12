/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017;

import java.util.ArrayList;
import java.util.List;
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
    public void testContains() 
    {
        Javafall2017 app = new Javafall2017();
        assertEquals(true ,app.Contains("jacob"));
    }
    
    @Test
    public void testGetQuantity() 
    {
        Javafall2017 app = new Javafall2017();
        assertEquals(4 ,app.GetQuantity("jacob"));
    }
    
    @Test
    public void testInsertAndDelete() 
    {
        Javafall2017 app = new Javafall2017();
        if(app.Contains("jill") == true)
        {
            app.Delete("jill");
            assertEquals(false ,app.Contains("jill"));
            app.Insert("jill", 1, 999);
            assertEquals(true ,app.Contains("jill"));
        }
        else
        {
            app.Insert("jill", 1, 999);
            assertEquals(true ,app.Contains("jill"));
            app.Delete("jill");
            assertEquals(false ,app.Contains("jill"));
        }  
    }
}
