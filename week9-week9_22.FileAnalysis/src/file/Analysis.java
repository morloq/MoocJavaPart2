/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author Admin
 */
import java.io.*;
public class Analysis {
    
    private File file;
    private BufferedReader reader = null;
    
    public Analysis(File file) throws Exception
    {
        this.file = file;
    }
    
    public int lines() throws IOException
    {
        FileInputStream fileStream = new FileInputStream(this.file);
        InputStreamReader input = new InputStreamReader(fileStream, "UTF-8");
        this.reader = new BufferedReader(input);
        String data;
        int lines = 0;
        while((data = reader.readLine()) != null)
        {
            lines++;
        }
        return lines;
    }
    
    public int characters() throws IOException
    {
        FileInputStream fileStream = new FileInputStream(this.file);
        /*
        FileInputStream class reads the file data into a stream of bytes
        */
        InputStreamReader input = new InputStreamReader(fileStream);
        /*
        InputStreamReader class wraps a Java InputStream such as FileInputStream. In the process it
        turns byte based InputStream into a character based Reader.
        In other words, the InputStreamReader interprets the bytes of an InputStream as text instead
        of numerical data. Is a subclass of Java Reader class.
        */
        this.reader = new BufferedReader(input);
        /*
        BufferedReader class provides buffering for Java Reader instances. Rather than read one
        character at a time from the underlying Reader, Java BufferedReader reads a large block
        (array) at a time, which is typically much faster.
        */
        
        int characters = 0;
        String data;
        while((data = reader.readLine()) != null)
        {
            characters += data.length();
        }
        return characters + this.lines();//to count line breaks
    }
}