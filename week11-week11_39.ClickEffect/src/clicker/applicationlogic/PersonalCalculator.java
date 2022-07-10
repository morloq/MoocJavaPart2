/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

/**
 *
 * @author Admin
 */
public class PersonalCalculator implements Calculator{
    
    private int value;
    
    public PersonalCalculator()
    {
        this.value = 0;
    }
    
    public int giveValue()
    {
        return this.value;
    }
    
    public void increase()
    {
        this.value++;
    }
}