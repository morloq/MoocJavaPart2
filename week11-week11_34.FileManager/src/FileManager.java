
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        
        File f = new File(file);
        Scanner scanner = new Scanner(f);
        List<String> FileLines = new ArrayList<String>();
        //both hasNext() and hasNextLine() work, whereas nextLine() != null provides an exception.
        while(scanner.hasNext())//why hasNext() and not scanner.hasNextLine() or scanner.nextLine() != null ????
        {
            String line = scanner.nextLine();
            if(!line.isEmpty())
            {
                FileLines.add(line);
            }
        }
        scanner.close();
        return FileLines;
    }

    public void save(String file, String text) throws IOException {
        File f = new File(file);
        FileWriter writer = new FileWriter(f);//no boolean as we want an already existing file to be overwritten
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        File f = new File(file);
        FileWriter writer = new FileWriter(f);//no boolean as well, so false,  so overwrite mode on
        for(String line : texts)
        {
            writer.write(line + "\n");
        }
        writer.close();
    }
}