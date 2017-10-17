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
    
    public void main(String[] args) 
    {
        Javafall2017 app = new Javafall2017();
        app.run();
    }
    
    public void run() 
    {
        int r1, r2, s;
        int[] num = new int[2];
        
        num = Input();
        r1 = num[0];
        s = num[1];
        
        r2 = doMath(r1, s);
        Output(r2);
    }
    
    public int[] Input(Scanner in) 
    {
        String input = in.nextLine(); 
        String[] numbers = input.split(" ");
        int[] rNumbers = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++)
        {
            rNumbers[i] = Integer.parseInt(numbers[i]);
        }
        return rNumbers;
    }
    
    public int[] Input()
    {
        Scanner in = new Scanner(System.in);
        return Input(in);
    }
    
    boolean inRange(int value) 
    {
        if(value >= -1000 && value <= 1000) {
            return true;
        }
        return false;
    }
    boolean isLessThan(int r1, int s)
    {
        if(r1 < s)
        {
            return true;
        }
        return false;
    }
    
    public int doMath(int r1, int s)
    {
        int r2;
        if(inRange(r1) && inRange(s))
        {
            if(isLessThan(r1, s))
            {
                r2 = s + (s - r1);
                return r2;
            }
            else
            {
                r2 = s - (r1 - s);
                return r2;
            }
        }
        return 0;
    }
    
    public void Output(int output)
    {
        System.out.println(output);       
    }
}
