/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Admin
 */
import java.util.*;
public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> MeasureResults;
    
    public AverageSensor()
    {
        this.sensors = new ArrayList<Sensor>();
        this.MeasureResults = new ArrayList<Integer>();
    }
    public void on()
    {
        for(Sensor sensor : sensors)
        {
            sensor.on();
        }
    }
    public void off()
    {
        for(Sensor sensor : sensors)
        {
            sensor.off();
        }
    }
    public boolean isOn()
    {
        boolean sensorsOn = false;
        for(Sensor sensor : sensors)
        {
            if(sensor.isOn())
            {
                sensorsOn = true;
            }
            else
                sensorsOn = false;
        }
        if(sensorsOn)
        {
            return true;
        }
        else
            return false;
    }
    public int measure()
    {
        if(!isOn() || sensors.isEmpty())
        {
            throw new IllegalStateException();
        }
        else
        {
            int Measure = 0;
            int amount = 0;
            for(Sensor sensor : sensors)
            {
                amount++;
                Measure += sensor.measure();
            }
            int averageMeasure = (Integer)Measure/amount;
            MeasureResults.add(averageMeasure);
            return (Integer)Measure/amount;
        }
    }
    
    public void addSensor(Sensor additional)
    {
        this.sensors.add(additional);
    }   
    
    public List<Integer> readings()
    {
        return this.MeasureResults;
    }
}