/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Admin
 */
import java.util.*;
public class ContainerHistory{
    
    private List<Double> history;
    
    public ContainerHistory()
    {
        this.history = new ArrayList<Double>();
    }
    
    public void add(double situation)
    {
        this.history.add(situation);
    }
    
    public void reset()
    {
        this.history.clear();
    }
    
    public double maxValue()
    {
        if(!this.history.isEmpty())
        {
            double greatest = this.history.get(0);
            for(Double d : history)
            {
                if(d > greatest)
                {
                    greatest = d;
                }
            }
            return greatest;
        }
        else
            return 0.0;
    }
    
    public double minValue()
    {
        if(!this.history.isEmpty())
        {
            double smallest = this.history.get(0);
            for(Double d : this.history)
            {
                if(d < smallest)
                {
                    smallest = d;
                }
            }
            return smallest;
        }
        else
            return 0.0;
    }
    
    public double average()
    {
        int sum = 0;
        for(int i = 0; i < history.size(); i++)
        {
            sum += history.get(i);
        }
        return (double)sum/this.history.size();
    }
    
    public double greatestFluctuation()
    {
        if(this.history.isEmpty() || this.history.size() < 2)
        {
            return 0.0;
        }
        else
        {
            double greatestFluctuation = 0;
            for(int i = 0; i < this.history.size()-1; i++)
            {
                double diff = Math.abs(history.get(i) - history.get(i+1));//dont do math.abs(i) as that will not be the value in history but the variable iin the loop!!!!
                if(diff > greatestFluctuation)
                {
                    greatestFluctuation = diff;
                }
            }
            return greatestFluctuation;
        }
    }
    
    public double variance()
    {
        if(!(this.history.isEmpty() || this.history.size() < 2))
        {
            double variance = 0;
                        
            for(int i = 0; i < history.size(); i++)
            {
                variance = variance + Math.pow((history.get(i) - average()), 2);//calculate variance step 1
            }
            variance = variance / (history.size()-1);//why -1 from size()?
            
            return variance;
        }
        else
            return 0.0;
    }
    
    @Override
    public String toString()
    {
        return history.toString();
    }
}