/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.*;
import reference.domain.*;

/**
 *
 * @author Admin
 */
public class FilmComparator implements Comparator<Film>{
    
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings)
    {
        this.ratings = ratings;
    }
    
    @Override
    public int compare(Film o1, Film o2)
    {
        
        int sumO2 = 0;
        for(Rating r : ratings.get(o2))
        {
            sumO2 += r.getValue();
        }
        
        int sumO1 = 0;
        for(Rating r : ratings.get(o1))
        {
            sumO1 += r.getValue();
        }
        
        if(sumO1 < sumO2)
        {
            return 1;
        }
        else if(sumO1 > sumO2)
        {
            return -1;
        }
        else
            return 0;
    }
}