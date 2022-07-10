
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
        printWithSmileys("Arto");
        printWithSmileys("Matti");
        
    }

    private static void printWithSmileys(String characterString)
    {
        int length = characterString.length();
        int max = (length/2) +3;
        if(length % 2 == 0)
        {
            printStars(max);
            System.out.println(":) " + characterString + " :)");
            printStars(max);
        }
        if(!(length % 2 == 0))
        {
            printStars(max+1);
            System.out.println(":) " + characterString + "  :)");
            printStars(max+1);
        }
    }
    private static void printStars(int max)
    {
        for(int i = 0; i < max; i++)
            {
                System.out.print(":)");
                
            }
        System.out.println("");
    }
}