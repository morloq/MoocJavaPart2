/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.*;
public class Dictionary {
    
    private HashMap<String,String> dictionary;
    
    public Dictionary()
    {
        this.dictionary = new HashMap<String,String>();
    }
    
    public String translate(String word)
    {
        if(this.dictionary.containsKey(word))
        {
            return this.dictionary.get(word);
        }
        else
            return null;
    }
    
    public void add(String word, String translation)
    {
        this.dictionary.put(word,translation);
    }
    
    public int amountOfWords()
    {
        return this.dictionary.size();
    }
    
    public ArrayList<String> translationList()
    {
        Set<String> keySet = dictionary.keySet();
        ArrayList<String> list = new ArrayList<String>(keySet);
        for(String str : list)
        {
            list.set(list.indexOf(str), translate(str) + " = " + str);
        }
        return list;
    }
}