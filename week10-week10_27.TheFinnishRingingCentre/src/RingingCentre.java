import java.util.*;
public class RingingCentre {
    
    private Map<Bird, List<String>> birds;
    
    public RingingCentre()
    {
        this.birds = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place)
    {
        if(!this.birds.containsKey(bird))
        {
            birds.put(bird, new ArrayList<String>());
        }
        birds.get(bird).add(place);
    }
    
    public void observations(Bird bird)
    {
        if(birds.get(bird) == null)
        {
            System.out.println(bird.toString() + " observations: " + 0);
            return;
        }
        System.out.println(bird.toString() + " observations: " + birds.get(bird).size());//size == times observed!
        System.out.println(birds.get(bird));
    }
}