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
public class Thermometer implements Sensor{
    private Random random;
    private boolean ThermometerOn;
    public boolean isOn()
    {
        if(ThermometerOn)
        {
            return true;
        }
        else
            return false;
    }
    public void off()
    {
        this.ThermometerOn = false;
    }
    public void on()
    {
        this.ThermometerOn = true;
    }
    public int measure()
    {
        if(isOn())
        {
            this.random = new Random();
            return random.nextInt(30-(-30) +1) +(-30);
        }
        else
            throw new IllegalStateException();
    }
}