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
public class BulkTank {
    
    private final double capacity;
    private double volume;
    
    public BulkTank()
    {
        this.volume = 0;
        this.capacity = 2000.0d;
    }
    
    public BulkTank(double capacity)
    {
        this.capacity = capacity;
    }
    
    public double getCapacity()
    {
        return this.capacity;
    }
    
    public double getVolume()
    {
        return this.volume;
    }
    
    public double howMuchFreeSpace()
    {
        return this.capacity - this.volume;
    }
    
    public void addToTank(double amount)
    {
        if(!(amount < 0))
        {
            if(this.volume == this.capacity)
            {
                
            }
            else if(this.volume + amount <= this.capacity)
            {
                this.volume += amount;
            }
            else
                this.volume = this.capacity;
        }
    }
    
    public double getFromTank(double amount)
    {
        if(!(amount < 0))
        {
            if(this.volume - amount <= 0)
            {
                this.volume = 0;
                return this.volume;
            }
            else if(this.volume - amount >= 0)
            {
                this.volume -= amount;
                return this.volume;
            }
        }
        return this.volume;
    }
    
    @Override
    public String toString()
    {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}