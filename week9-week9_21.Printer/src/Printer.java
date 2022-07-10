/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Printer {
    
    private final String fileName;
    private final File file;
    private  Scanner reader;
    
    public Printer(String fileName) throws Exception
    {
        this.fileName = fileName;
        this.file = new File(fileName);
        
    }
    
    public void printLinesWhichContain(String word) throws Exception
    {
        this.reader = new Scanner(file, "UTF-8");
        while(reader.hasNext())
        {
            if(word.isEmpty())
            {
                while(reader.hasNextLine())
                {
                    System.out.println(reader.nextLine());
                }
            }
            else
            {   
                String line = reader.nextLine();
                if(line.contains(word))
                {
                    System.out.println(line);
                }
            }
        }
    }
}