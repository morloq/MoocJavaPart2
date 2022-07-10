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
public class Farm implements Alive{
    
    private final Barn barn;
    private final String owner;
    private Collection<Cow> cows;//not instantialized!!!!! wtf am i dumb
    
    public Farm(String owner, Barn barn)
    {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public void addCow(Cow cow)
    {
        cows.add(cow);
    }
    
    public void installMilkingRobot(MilkingRobot robot)
    {
        barn.installMilkingRobot(robot);
    }
    
    public String getOwner()
    {
        return this.owner;
    }
    
    @Override
    public void liveHour()
    {
        for(Cow cow : cows)
        {
            cow.liveHour();
        }
    }
    
    public void manageCows()
    {
        barn.takeCareOf(cows);
    }
    
    @Override
    public String toString()
    {
        String cows = "";
        if(cows.isEmpty())
        {
            cows = "No cows.";
        }
        else
        {
            cows = "Animals:\n";
            for(Cow cow : this.cows)
            {
                cows += cow.toString();
            }
        }
        return "Farm owner: " + getOwner() + "\n"
             + "Barn bulk tank: " + barn.getBulkTank().toString() + "\n"
             + cows;
    }
}