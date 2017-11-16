/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafall2017;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jacob
 */
public class Javafall2017 {

     public static void main(String[] args) 
     {
        new Javafall2017().run();
     }

    void run() 
    {
        List<String> names = new ArrayList<>();
        AddName(names, "Jacob");
        AddName(names, "Jamin");
        AddName(names, "Jared");
        
        PrintList(names);
        
        AddName(names, "Jacob");
        RemoveName(names, "Jacob");
        
        PrintList(names);
        RemoveName(names, "Jacob");
    }
    
    public void AddName(List<String> _names, String name)
    {
        if(_names.contains(name))
        {
            System.out.println("<< error >> trying to add " + name + " :: already in the list");
        }
        else
        {
            _names.add(name);
            System.out.println("<< " + name + " >> added");
        }
    }
    
    public void RemoveName(List<String> _names, String name)
    {
        if(!_names.contains(name))
        {
            System.out.println("<< error >> trying to remove " + name + " :: not found in the list");
        }
        else
        {
            _names.remove(name);
            System.out.println("<< " + name + " >> removed");
        }
    }
    
    public void PrintList(List<String> _names)
    {
        System.out.println("");
        for(String name : _names)
        {
            System.out.println(name);
        }
        System.out.println("");
    }
}