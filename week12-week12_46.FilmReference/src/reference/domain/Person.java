package reference.domain;

public class Person {
    
    private String name;
    
    public Person(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public String toString()
    {
        return this.getName();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(this.getClass() != obj.getClass())
        {
            return false;
        }
        if(this == null)
        {
            return false;
        }
        
        Person person = (Person)obj;
        
        return person.getName().equals(this.getName());
    }
    
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }
}