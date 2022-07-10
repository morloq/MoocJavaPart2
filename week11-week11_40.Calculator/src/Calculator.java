/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Calculator {
    private static int value;
    
    public static int getCurrentValue()
    {
        return value;
    }
    
    public static void add(int amount)
    {
        value += amount;
    }
    
    public static void subtract(int amount)
    {
        value -= amount;
    }
    
    public static void clear()
    {
        value = 0;
    }
}