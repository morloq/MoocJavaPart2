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
public class Box implements ToBeStored {
    private double maxWeight;
    private ArrayList<ToBeStored> elementsInBox;
    
    public Box(double maxWeight)
    {
        this.maxWeight = maxWeight;
        this.elementsInBox = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored element)
    {
        if(weight() + element.weight() <= maxWeight)
        {
            elementsInBox.add(element);
        }
    }
    @Override
    public String toString()
    {
        return "Box: " + elementsInBox.size() + " things, total weight " + weight() + " kg";
    }
    
    public double weight()
    {
        double weight = 0;
        if(!elementsInBox.isEmpty())
        {
            for(ToBeStored s : elementsInBox)
            {
                weight += s.weight();
            }
        }
        
        return weight;
    }
}