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
public class TextUserInterface {
    private final Scanner reader;
    private final Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary)
    {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start()
    {
        System.out.print("Statement:\n");
        System.out.println("   add - adds a word pair to the dictionary");
        System.out.println("   translate - asks a word and prints its tranlsation");
        System.out.println("   quit - quit the text user interface\n");
        
        ArrayList<String> commands = new ArrayList<String>();
        commands.add("add");
        commands.add("translate");
        commands.add("quit");
        
        while(true)
        {
            System.out.print("Statement: ");
            String input = reader.nextLine();
            
            
            if(input.equals("add"))
            {
                add();
            }
            if(input.equals("translate"))
            {
                translate();
            }
            if(!commands.contains(input))
            {
                System.out.println("Unknown Statement\n");
            }
            if(input.equals("quit"))
            {
                System.out.println("Cheers!");
                break;
            }
        }
    }
    public void translate()
    {
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        String translation = dictionary.translate(word);
        System.out.print("Translation: " + translation);
    }
    public void add()
    {
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(word, translation);
        System.out.println("");
    }
}