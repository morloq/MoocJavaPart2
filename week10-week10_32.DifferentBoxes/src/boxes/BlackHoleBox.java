/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author Admin
 */
import java.util.*;
public class BlackHoleBox extends Box{
    
    private Collection<Thing> blackbox;
    
    public BlackHoleBox()
    {
        this.blackbox = new ArrayList<Thing>();
    }
    
    @Override
    public boolean isInTheBox(Thing thing)
    {
        return false;
    }
    
    @Override
    public void add(Thing thing)
    {
        blackbox.add(thing);
    }
}