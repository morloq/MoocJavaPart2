/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.Comparator;
public class SortAgainstPoints implements Comparator<Jumper> {
    public int compare(Jumper jumper1, Jumper jumper2)
    {
        if(jumper1.getPoints() > jumper2.getPoints())
        {
            return 1;
        }
        else if(jumper1.getPoints() < jumper2.getPoints())
        {
            return -1;
        }
        else
            return 0;
    }
}