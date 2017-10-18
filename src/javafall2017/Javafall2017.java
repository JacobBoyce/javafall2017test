/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017;

import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class Javafall2017 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        Javafall2017 app = new Javafall2017();
        app.run();
    }
    
    public void run() 
    {
        System.out.println(isEvenOdd(2));
        System.out.println(isEvenOdd(10));
        System.out.println(isEvenOdd(15));
        System.out.println(isEvenOdd(-2));
        System.out.println(isEvenOdd(-15));
    }
    
    public String isEvenOdd(int num)
    {
        boolean iseven = isEven(num);
        if(iseven == true)
        {
            return num + " is even";
        }
        else if(iseven == false)
        {
            return num + " is odd";
        }
        else
        {
            return "Cant tell what " + num + " is";
        }
    }
    
    public boolean isEven(int num)
    {
        int temp = 0;
        temp = num % 2;
        
        if(temp == 0)
        {
            return true;
        }
        return false;
    }
}