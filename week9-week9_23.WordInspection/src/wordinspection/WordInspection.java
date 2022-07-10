/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

/**
 *
 * @author Admin
 */
import java.util.*;
import java.io.*;
public class WordInspection {
    
    private Scanner scanner;
    private final File file;
    private List<String> words;
    
    public WordInspection(File file)
    {
        this.file = file;
    }
    
    public int wordCount() throws FileNotFoundException
    {
        int NumberOfWords = 0;
        this.words = new ArrayList<String>();
        this.scanner = new Scanner(this.file, "UTF-8");
        while(scanner.hasNext())
        {
            words.add(scanner.next());
            NumberOfWords++;
        }
        
        return NumberOfWords;
    }
    
    public List<String> wordsContainingZ() throws FileNotFoundException
    {
        List<String> containsZ = new ArrayList<String>();
        wordCount();
        for(String s : this.words)
        {
            if(s.contains("z"))
            {
                containsZ.add(s);
            }
        }
        return containsZ;
    }
    
    public List<String> wordsEndingInL() throws FileNotFoundException
    {
        wordCount();
        List<String> wordsEndingInL = new ArrayList<String>();
        for(String s : this.words)
        {
            if(s.endsWith("l"))
            {
                wordsEndingInL.add(s);
            }
        }
        return wordsEndingInL;
    }
    
    public List<String> palindromes() throws FileNotFoundException
    {
        wordCount();
        List<String> palindromes = new ArrayList<String>();
        for(String s : this.words)
        {
            char[] charArray = s.toCharArray();//string to char
            
            for(int i = 0; i < (Integer)s.length()/2; i++)//reverse chararray
            {
                char temp = charArray[i];
                charArray[i] = charArray[charArray.length - i -1];
                charArray[charArray.length - i - 1] = temp;
            }
            String b = new String(charArray);//convert back to string
            if(s.equals(b))//check if palindrome
            {
                palindromes.add(s);
            }
        }
        return palindromes;
    }
    
    public List<String> wordsWhichContainAllVowels() throws FileNotFoundException
    {
        wordCount();
        List<String> wordsWithAllVowels = new ArrayList<String>();
        for(String s : this.words)
        {
            s = s.toLowerCase();
            if(s.contains("a") && s.contains("e") && s.contains("i") && s.contains("o") && s.contains("u")
                    && s.contains("y") && s.contains("ä") && s.contains("ö"))
            {
                wordsWithAllVowels.add(s);
            }
        }
        
        return wordsWithAllVowels;
    }
}