package dictionary;
import java.util.*;
import java.io.*;
import java.util.logging.*;
public class MindfulDictionary {
    
    private Map<String,String> dictionary;
    private File file;
    private String fileName;
    private boolean loaded = false;//crude solution, but works, so meh
    
    public MindfulDictionary()
    {
        this.dictionary  = new HashMap<String,String>();
    }
    
    public MindfulDictionary(String file)
    {
       this.dictionary  = new HashMap<String,String>();
       this.fileName = file;
    }
    
    public boolean load()
    {
        //does this work????
        try{
            this.file = new File(this.fileName);
            
            Scanner fileReader = new Scanner(this.file);
            while(fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                for(int i = 0; i < parts.length; i+=2)
                {
                    add(parts[i], parts[i+1]);//added to hashmap dictionary
                }
            }
            loaded = true;
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean save()
    {
        
            if(!loaded)
            {
                load();
            }
            try{
            FileWriter writer = new FileWriter(this.file);
            
            for(String s : this.dictionary.keySet())
            {
                writer.write(s + ":" + this.dictionary.get(s) + "\n");
            }
            
            writer.close();
            return true;
            }
            catch(Exception e)
            {
                return this.file == null;
            }
    }
    
    public void add(String word, String translation)
    {
        if(!this.dictionary.containsKey(word))
        {
            this.dictionary.put(word,translation);
        }
    }
    
    public String translate(String word)
    {
        if(this.dictionary.containsKey(word))//if word to be translated is key
        {
            return this.dictionary.get(word);
        }
        else
        {
            for(String s : this.dictionary.keySet())
            {
                if(word.equals(this.dictionary.get(s)))//if word to be translated is value 
                {
                    return s;
                }
            }
        }
        return null;//if word is neither the key nor the value
    }
    
    public void remove(String word)
    {
        if(this.dictionary.containsKey(word))
        {
            this.dictionary.remove(word);
        }
        List<String> toberemoved = new ArrayList<String>();
        for(String s : this.dictionary.keySet())
        {
            if(word.equals(this.dictionary.get(s)))
            {
                toberemoved.add(s);//cannot alter the dictionary while also iterating it :(
            }
        }
        for(String remove : toberemoved)
        {
            this.dictionary.remove(remove);
        }
    }
}