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
public class OneThingBox extends Box{
    
    private Thing thing;
    
    @Override
    public boolean isInTheBox(Thing thing)
    {
       return this.thing != null && this.thing.equals(thing);
    }
    
    @Override
    public void add(Thing thing)
    {
        if(this.thing == null)
        {
            this.thing = thing;//no use working with collections if there is only one thing in "box"
        }
    }
}