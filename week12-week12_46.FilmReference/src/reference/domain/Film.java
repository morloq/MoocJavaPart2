package reference.domain;

public class Film {
    
    private String name;
    
    public Film(String name)
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
        
        Film film = (Film)obj;
        
        return film.getName().equals(this.getName());
    }
    
    @Override
    public int hashCode()
    {
        return this.name.hashCode();
    }
}