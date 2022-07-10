package boxes;
import java.util.*;

public class MaxWeightBox extends Box{
    
    private final int maxWeight;
    private Collection<Thing> box;
    
    public MaxWeightBox(int maxWeight)
    {
        this.maxWeight = maxWeight;
        this.box = new ArrayList<Thing>();
    }
    
    @Override
    public boolean isInTheBox(Thing thing)
    {
        return box.contains(thing);
    }
    
    @Override
    public void add(Thing thing)
    {
        if(currentWeight() + thing.getWeight() <= maxWeight)
        {
            box.add(thing);
        }
    }
    
    public int currentWeight()
    {
        int currentWeight = 0;
        for(Thing thing : box)
        {
            currentWeight += thing.getWeight();
        }
        return currentWeight;
    }
}