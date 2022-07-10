/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

/**
 *
 * @author Admin
 */
import java.util.*;
public class Group implements Movable{
    
    private List<Movable> movables = new ArrayList<Movable>();
    
    @Override
    public String toString()
    {
        String PrintMovables = "";//Could have used stringbuilder and append objeccts.toString instead
        for(Movable movable : movables)
        {
            PrintMovables += movable.toString() + "\n";
        }
        return PrintMovables;
    }
    
    public void addToGroup(Movable movable)
    {
        this.movables.add(movable);
    }
    
    @Override
    public void move(int dx, int dy)
    {
        for(Movable movable : movables)
        {
            movable.move(dx, dy);
        }
    }
}