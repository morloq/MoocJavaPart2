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
public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases;
    
    public Container(int maxWeight)
    {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase)
    {
        int sum = 0;
        for(Suitcase s : suitcases)
        {
            sum += s.totalWeight();
        }
        if(sum + suitcase.totalWeight() <= maxWeight)
        {
            this.suitcases.add(suitcase);
        }
    }
    
    public String toString()
    {
        int counter = 0;
        int weight = 0;
        for(Suitcase suitcase : suitcases)
        {
            counter++;
            weight += suitcase.totalWeight();
            
        }
        if(suitcases.size() == 1)
        {
            return counter + " suitcase (" + weight + " kg)";
        }
        else
        {
            return counter + " suitcases (" + weight + " kg)";
        }
    }
    
    public void printThings()
    {
        for(Suitcase suitcase : suitcases)
        {
            suitcase.printThings();
        }
    }
}