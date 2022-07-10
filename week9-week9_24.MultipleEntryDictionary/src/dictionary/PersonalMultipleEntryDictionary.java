package dictionary;
import java.util.*;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{
    
    private Map<String,Set<String>> dictionary;
    
    public PersonalMultipleEntryDictionary()
    {
        this.dictionary = new HashMap<String,Set<String>>();
    }
    public void add(String word, String entry)
    {
        if(this.dictionary.containsKey(word))
        {
            this.dictionary.get(word).add(entry);
        }
        else
        {
            this.dictionary.put(word, new HashSet<String>());
            this.dictionary.get(word).add(entry);
        }
    }
    
    public Set<String> translate(String word)
    {        
        if(!dictionary.containsKey(word))
        {
            return null;//return null if word not in dictionary
        }
        else
        {
            Set<String> entries = dictionary.get(word);
            return entries;
            //if word in dictionary, return the entries
        }
    }
    
    public void remove(String word)
    {
        if(this.dictionary.containsKey(word))
        {
            dictionary.remove(word);
        }
    }
}