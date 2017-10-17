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


    /**
     * Test of Input method, of class Hmwk2.
     */
    @Test
    public void testInput_Scanner() {
        Javafall2017 app = new Javafall2017();
        Scanner in = new Scanner("11 15");
        int[] expResult = new int[2];

        expResult = app.Input(in);
        assertEquals(expResult[0], 11);
        assertEquals(expResult[1], 15);
    }
    
    @Test
    public void testInRange() {
        Javafall2017 app = new Javafall2017();
        assertEquals(false,app.inRange(-1001));
        assertEquals(true,app.inRange(-1000));
        assertEquals(true,app.inRange(1000));
        assertEquals(false,app.inRange(1001));
        assertEquals(true,app.inRange(100));
    }  
    
    @Test
    public void testIsLessThan() {
        Javafall2017 app = new Javafall2017();
        assertEquals(false,app.isLessThan(4, 3));
        assertEquals(true,app.isLessThan(11, 15));
    } 
    
    @Test
    public void testDoMath()
    {
        Javafall2017 app = new Javafall2017();
        int r1, r2, s;
        r1 = 4;
        s = 3;
        r2 = 2;
        
        assertEquals(r2, app.doMath(r1, s));
       
    }
}
