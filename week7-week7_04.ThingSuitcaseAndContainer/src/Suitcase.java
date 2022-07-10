/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.*;
public class Suitcase {
    private int maxWeight;
    private ArrayList<Thing> things;
    
    public Suitcase(int maxWeight)
    {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing)//if we initialize the arraylist in here, a new one will be created
            //for each call of the method instead of one for all.... stupid!
    {
        int sum = 0;
        for(Thing t : things)
        {
            sum += t.getWeight();
        }
        if(sum + thing.getWeight() <= maxWeight)
        {
            things.add(thing);
        }
    }
    
    public String toString()
    {
        int counter = 0;
        int weight = 0;
        for(Thing i : things)
        {
            counter++;
            weight += i.getWeight();
        }
        if(things.size() == 0)
        {
            return "empty (" + weight + " kg)";
        }
        if(things.size() == 1)
        {
            return counter + " thing (" + weight + " kg)";
        }
        else
            return counter + " things (" + weight + " kg)";//weight shown not right
    }
    
    public void printThings()
    {
        for(Thing i : things)
        {
            System.out.println(i);
        }
    }
    
    public int totalWeight()
    {
        int i = 0;
        for(Thing t : things)
        {
            i += t.getWeight();
        }
        return i;
    }
    //heaviest thing
    
    public Thing heaviestThing()
    {

        //if Thing heaviestThing = this.things.get(0); is done here, there will be an error should
        //things actually be empty. instead test for that first, if empty it will return null and
        //exit the method. If not empty, Thing heaviestThing will be created and can be used.
        if(this.things.isEmpty())
        {
            return null;
        }
        Thing heaviestThing = this.things.get(0);
        for(Thing thing : things)
        {
            if(thing.getWeight() > heaviestThing.getWeight())
            {
                heaviestThing = thing;
            }
        }
        return heaviestThing;
    }
}