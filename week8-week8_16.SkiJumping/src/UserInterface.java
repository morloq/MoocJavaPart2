import java.util.*;
public class UserInterface {
    
    private Jumper jumper;
    
    public UserInterface()
    {
        this.jumper = new Jumper("");
    }
    public void start(Scanner reader)
    {
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while(true)
        {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            
            if(!name.isEmpty())
            {
                jumper.add(name);
            }
            else if(name.isEmpty())
            {
                System.out.println("");
                break;
            }
        }
        System.out.println("The tournament begins!\n");
        rounds(reader);
    }
    
    public void sortAgainstPoints(ArrayList<Jumper> list)
    {
        Collections.sort(list, new SortAgainstPoints());
    }
    
    public void rounds(Scanner reader)
    {
        int roundCounter = 0;
        ArrayList<Jumper> list = new ArrayList<Jumper>(jumper.getJumpers().values());
        
        while(true)
        {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            System.out.println("");
            roundCounter ++;
            
            if(!input.equals("jump"))
            {
                break;
            }
            
            System.out.println("Round " + roundCounter + "\n");//Round 1 ...
            
            System.out.println("Jumping order:");
             
            
            int counter = 0;
            
            for(Jumper p : list)
            {
                counter++;
                System.out.println("  " + counter + ". " + p);
            }
            
            System.out.println("");
            System.out.println("Results of round " + roundCounter);
            
            for(Jumper p : list)
            {
                int jumpLength = p.jump();
                p.addJumpLength(jumpLength);
                
                int[] judgesScores  = p.judgeScores();
                
                int score = 0;
                score += p.jumpScore(jumpLength, judgesScores);
                p.setPoints(p.getPoints() + score);//why did I not realise sooner that just setting the points to the score would overwrite the previous one!! add it as well you dickhead!!!!
                
                System.out.print("  " + p.getName() + "\n" +
                        "    length: " + jumpLength + "\n" +
                        "    judge votes: " + p.printJudgesScores(judgesScores) +"\n"
                        );
            }
            sortAgainstPoints(list);
            System.out.println("");
        }
        
        Collections.reverse(list);//highest scored jumper first
        System.out.println("Thanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println((i +1) + "           " + list.get(i).getName() + " (" + list.get(i).getPoints() + ")\n"
                    + "            jump lengths: " + list.get(i).printJumpLengths());
        }
    }
}