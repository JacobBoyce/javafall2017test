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
    public void test() {
        Javafall2017 app = new Javafall2017();
        List<String> names = new ArrayList<>();
        app.AddName(names, "Jacob");
        assertEquals(true, names.contains("Jacob"));
        app.RemoveName(names, "Jacob");
        assertEquals(false, names.contains("Jacob"));
    }
}
