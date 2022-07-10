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
public class MilkingRobot {
    
    private BulkTank bulkTank;
    
    public MilkingRobot()
    {
    
    }
    
    public BulkTank getBulkTank()
    {
        return this.bulkTank;
    }
    
    public void setBulkTank(BulkTank tank)
    {
        this.bulkTank = tank;
    }
    
    public void milk(Milkable milkable) throws IllegalStateException
    {
        if(this.bulkTank == null)
        {
            throw new IllegalStateException();
        }
        double milk = milkable.milk();
        milkable.milk();
        this.bulkTank.addToTank(milk);
    }
}