package reference;
import java.util.*;
import reference.comparator.FilmComparator;
import reference.domain.*;

public class Reference {
    
    private final RatingRegister register;
    
    public Reference(RatingRegister ratingRegister)
    {
        this.register = ratingRegister;
    }
    
    private int calculateSimilarity(Person person1, Person person2)
    {
        Map<Film,Rating> person1Ratings = register.getPersonalRatings(person1);
        Map<Film,Rating> person2Ratings = register.getPersonalRatings(person2);
        int similarity = 0;
        for(Film film : person1Ratings.keySet())
        {
            for(Film f : person2Ratings.keySet())
            {
                if(film.equals(f))
                {
                    similarity += register.getRating(person1, film).getValue() * register.getRating(person2, f).getValue();
                }
            }
        }
        return similarity;
    }    
    
    public Person bestMatchedPerson(List<Person> people, Person person)
    {
        Person mostSuitable = null;
        Integer tempSimilarity = 0;
        for(Person p : people)
        {
            if(p.equals(person))
            {
                continue;//forgott about that, whoops
            }
            Integer similarity = calculateSimilarity(person, p);
            if(similarity > tempSimilarity)
            {
                mostSuitable = p;
                tempSimilarity = similarity;
            }
        }
        return mostSuitable;
    }
    
    public boolean hasRecommended(Person person)
    {
        List<Person> reviewers = register.reviewers();
        boolean hasReviewed = false;
        for(Person p : reviewers)
        {
            if(p.equals(person))
            {
                hasReviewed = true;
                break;
            }
        }
        return hasReviewed;
    }
    
    public Film hasNotRecommended(Person person)
    {
        Map<Film,List<Rating>> films = register.filmRatings();
        
            HashMap<Integer,Film> rec = new HashMap<Integer,Film>();
            for(Film f : films.keySet())
            {
                int ratings = 0;
                List<Rating> r = register.getRatings(f);
                for(Rating rating : r)
                {
                    ratings += rating.getValue();
                }
                rec.put(ratings,f);
            }
            int highestRated = 0;
            for(Integer i : rec.keySet())
            {
                if(i > highestRated)
                {
                    highestRated = i;
                }
            }
            Film film = rec.get(highestRated);
        
        return film;
    }
    
    public List<Film> ListFromSuitablePerson(Person suitable, Person needsRec)
    {
        List<Film> recommendedFilms = new ArrayList<Film>();
        
        Map<Film,Rating> suitablePersonRating = register.getPersonalRatings(suitable);
        Map<Film,Rating> needsRecRating = register.getPersonalRatings(needsRec);
        
        
        
        int threshold = 1;
        
        for(Film film : suitablePersonRating.keySet())
        {
            if(aboveThreshold(suitablePersonRating, film, threshold) && !watched(needsRecRating, film))
            {
                recommendedFilms.add(film);
            }
        }
        return recommendedFilms;
    }
    
    public boolean aboveThreshold(Map<Film,Rating> filmRatingMap, Film film, int threshold)
    {
        return filmRatingMap.get(film).getValue() > threshold;
    }
    
    public boolean watched(Map<Film,Rating> watchedMap, Film film)
    {
        return watchedMap.keySet().contains(film);
    }
    
    public boolean canFindSimilarTaste(Person needsRec)
    {
        Map<Film,Rating> personalRatings = register.getPersonalRatings(needsRec);
        return (personalRatings != null && !personalRatings.isEmpty());
    }
    
    public Film recommendHighestRatedFilm(List<Film> films, FilmComparator comparator)
    {
        if(films.isEmpty())
        {
            return null;
        }
        else
        {
            films.sort(comparator);
            return films.get(0);
        }
    }
    
    public Film recommendFromSuitablePerson(Person needsRec, FilmComparator comparator)
    {
        Person suitablePerson = bestMatchedPerson(register.reviewers(), needsRec);
        if(suitablePerson == null)
        {
            return null;
        }
        List<Film> recommendedFilms = ListFromSuitablePerson(suitablePerson, needsRec);
        return recommendHighestRatedFilm(recommendedFilms, comparator);
    }
    
    public Film recommendFilm(Person person)
    {
        Map<Film,List<Rating>> films = register.filmRatings();
        Map<Film,Rating> personalRatings = register.getPersonalRatings(person);
        FilmComparator comparator = new FilmComparator(films);
        
        Film film = new Film("");
        if(!hasRecommended(person)){film = hasNotRecommended(person);}
        else{
            if(!canFindSimilarTaste(person))
            {
                film = recommendHighestRatedFilm(new ArrayList<Film>(films.keySet()), comparator);
            }
            else
                film = recommendFromSuitablePerson(person, comparator);
        }
        
        return film;
        
    }
}