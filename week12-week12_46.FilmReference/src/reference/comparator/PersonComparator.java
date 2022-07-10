package reference.comparator;
import java.util.*;
import reference.domain.Person;

public class PersonComparator implements Comparator<Person>{
    
    private final Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities)
    {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person o1, Person o2)
    {
        int sumO2 = peopleIdentities.get(o2);
        int sumO1 = peopleIdentities.get(o1);
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