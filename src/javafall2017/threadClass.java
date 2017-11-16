/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017;

/**
 *
 * @author boyse
 */
public class threadClass extends Thread 
{
    threadClass()
    {
        
    }
    
    @Override
    public void run()
    {
        System.out.println("i do stuff");
        
        try {
            System.out.println("going to sleep");
            Thread.sleep((int) Math.random() * 100);
            System.out.println("im awake");
        } catch (InterruptedException ex) {
            System.out.println("didnt work");
        }
    }
}
