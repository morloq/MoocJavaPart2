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
import java.util.Collection;
public class Barn {
    
    private BulkTank bulkTank;
    private MilkingRobot robot;
    
    public Barn(BulkTank tank)
    {
        this.bulkTank = tank;
    }
    
    public BulkTank getBulkTank()
    {
        return this.bulkTank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot)
    {
        this.robot = milkingRobot;
        robot.setBulkTank(this.bulkTank);
    }
    
    public void takeCareOf(Collection<Cow> cows) throws IllegalStateException
    {
        if(robot == null)
        {
            throw new IllegalStateException();
        }
        else
        {
            for(Cow cow : cows)
            {
                robot.milk(cow);
            }
        }
    }
    
    public void takeCareOf(Cow cow) throws IllegalStateException
    {
        if(robot == null)
        {
            throw new IllegalStateException();
        }
        else
            robot.milk(cow);
    }
    
    @Override
    public String toString()
    {
        return this.bulkTank.toString();
    }
}