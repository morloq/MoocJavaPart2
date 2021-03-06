
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container)
    {
        int i = 1;
        while(i <= 100)
        {
            Thing brick = new Thing("Brick", 0 + i);
            Suitcase s = new Suitcase(4 +i);
            s.addThing(brick);
            container.addSuitcase(s);
            i++;
        }
    }
}