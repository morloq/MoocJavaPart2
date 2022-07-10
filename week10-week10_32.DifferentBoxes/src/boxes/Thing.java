package boxes;
import java.util.Objects;
public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) throws IllegalArgumentException{
        
        if(weight < 0)
        {
            throw new IllegalArgumentException();
        }
        this.weight = weight;
        this.name = name;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(this.name);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Thing))
        {
            return false;
        }
        
        Thing thing = (Thing) obj;
        if(this.name.equals(thing.name))
        {
            return true;
        }
        return false;
    }
    
    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}