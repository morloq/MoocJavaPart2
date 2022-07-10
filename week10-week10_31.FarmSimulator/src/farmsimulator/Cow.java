/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Admin
 */
import java.util.*;
public class Cow implements Milkable,Alive{
    
    private String name;
    private Random random = new Random();
    private double udderCapacity = (double)random.nextInt(40 - 15 +1) + 15;
    private double amount;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Cow()
    {
        this.name = NAMES[new Random().nextInt(NAMES.length-1)];
    }
    
    public Cow(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public double getCapacity()
    {
        return this.udderCapacity;
    }
    
    public double getAmount()
    {
        return this.amount;
    }
    
    @Override
    public double milk()
    {
        double milk = amount;
        this.amount = 0;
        return milk;
    }
    
    @Override
    public void liveHour()
    {
        double add = 0.7 + (2.0 - 0.7) * random.nextDouble();
        if(this.amount + add <= this.udderCapacity)
        {
            this.amount += add;
        }
        else if(this.amount + add > this.udderCapacity)
        {
            this.amount = this.udderCapacity;
        }
    }
    
    @Override
    public String toString()
    {
        return this.name + " " + Math.ceil(getAmount()) + "/" + getCapacity();
    }
}