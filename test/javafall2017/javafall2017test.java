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


/*
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
    */
    @Test
    public void testIsEven() {
        Javafall2017 app = new Javafall2017();
        assertEquals(true,app.isEven(14));
        assertEquals(true,app.isEven(40));
        assertEquals(false,app.isEven(67));
        assertEquals(true,app.isEven(-28));
        assertEquals(false,app.isEven(-23));
    }    
}
