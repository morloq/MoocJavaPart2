import java.util.*;
public class Main {
    public static void main(String[] args) {
        // write test code here
    }
    
    public static boolean isAWeekDay(String string)
    {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public static boolean allVowels(String string)
    {
        string = string.toLowerCase();
        return string.matches("[aeiouäöü]+");
    }
    
    public static boolean clockTime(String string)
    {
        return string.matches("(([01][0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]");
    }
}