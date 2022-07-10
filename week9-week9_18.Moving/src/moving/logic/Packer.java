/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;
import moving.domain.Box;
import moving.domain.Thing;
/**
 *
 * @author Admin
 */
import java.util.*;
public class Packer {
    private int boxesVolume;
    
    public Packer(int boxesVolume)
    {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things)
    {
        List<Box> packed = new ArrayList<Box>();
        Box box = new Box(this.boxesVolume);//new Box with given volume limit
       
        for(Thing thing : things)
        {
            if(box.addThing(thing))
            {
                box.addThing(thing);
            }
            //if things do not fit anymore, add box to packed and create new box
            packed.add(box);
            box = new Box(this.boxesVolume);
        }
        
        return packed;
    }
}