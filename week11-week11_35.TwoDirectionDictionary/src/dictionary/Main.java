package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        MindfulDictionary dict = new MindfulDictionary("test/tmp/tmp58984.txt");
        dict.add("tietokone","computer");
        //System.out.println(dict.load());

        System.out.println(dict.save());
    }
}