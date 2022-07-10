package reference;
import reference.domain.*;
import java.util.*;
public class RatingRegister {
    
    private final Map<Film, List<Rating>> register;
    private final Map<Person, HashMap<Film,Rating>> personratings;
    
    public RatingRegister()
    {
        this.register = new HashMap<Film,List<Rating>>();
        this.personratings = new HashMap<Person, HashMap<Film,Rating>>();
    }
    
    public void addRating(Film film, Rating rating)
    {   
        if(!register.containsKey(film))
        {
            register.put(film, new ArrayList<Rating>());
        }
        
        register.get(film).add(rating);
    }
    
    public void addRating(Person person, Film film, Rating rating)
    {
        if(!personratings.containsKey(person))
        {
            personratings.put(person, new HashMap<Film,Rating>());
        }
        personratings.get(person).put(film, rating);
        
        addRating(film,rating);
    }
    
    public List<Rating> getRatings(Film film)
    {   
        if(register.containsKey(film))
        {
            return register.get(film);
        }
        return null;
    }
    
    public Rating getRating(Person person, Film film)
    {
        if(!personratings.get(person).containsKey(film))
        {
            return Rating.NOT_WATCHED;
        }
        else
            return personratings.get(person).get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings()
    {
        return register;
    }
    
    public Map<Film,Rating> getPersonalRatings(Person person)
    {
        if(!personratings.containsKey(person))
        {
            addEmptyReviewer(person);//because, if a person does not have any rating, the returned
            //map cannot/may not be null
            //so if we create an empty list for the person that has not rated anything, it won't be
        }
        return personratings.get(person);
    }
    
    public void addEmptyReviewer(Person person)
    {
        HashMap<Film,Rating> emptyRatingMap = new HashMap <Film,Rating>();
        personratings.put(person, emptyRatingMap);
    }
    
    public List<Person> reviewers()
    {
        return new ArrayList<Person>(personratings.keySet());
    }
}