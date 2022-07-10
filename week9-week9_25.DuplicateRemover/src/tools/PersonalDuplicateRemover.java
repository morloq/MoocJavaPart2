package tools;
import java.util.*;

public class PersonalDuplicateRemover implements DuplicateRemover{
    private Set<String> set;
    private int numberOfDuplicates;
    
    public PersonalDuplicateRemover()
    {
        this.set = new HashSet<String>();
    }
    @Override
    public void add(String characterString)
    {
        
        if(!this.set.contains(characterString))
        {
            this.set.add(characterString);
        }
        else
            this.numberOfDuplicates++;
    }
    @Override
    public int getNumberOfDetectedDuplicates()
    {
        
        return this.numberOfDuplicates;
    }
    @Override
    public Set<String> getUniqueCharacterStrings()
    {
        return this.set;
    }
    @Override
    public void empty()
    {
        this.numberOfDuplicates = 0;
        this.set.clear();
    }
}