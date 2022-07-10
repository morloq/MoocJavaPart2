/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author Admin
 */
import java.util.*;
public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> boxcontents;//list is just an interface, no initialization possible, instead
    //initialize a class that implements list, such as arraylist
    
    public Box(int maximumCapacity)
    {
        this.maximumCapacity = maximumCapacity;
        this.boxcontents = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing)
    {
        if(this.getVolume() + thing.getVolume() <= this.maximumCapacity)
        {
            boxcontents.add(thing);
            return true;
        }
        else
            return false;
    }
    
    @Override
    public int getVolume()
    {
        int totalvolume = 0;
        for(Thing thing : boxcontents)
        {
            totalvolume += thing.getVolume();
        }
        return totalvolume;
    }
}