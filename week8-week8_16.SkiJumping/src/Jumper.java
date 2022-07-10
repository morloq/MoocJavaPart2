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
public class Jumper {
    private String name;
    private int points;
    private Random random;
    private int[] judges;
    private ArrayList<Integer> jumpLengths;
    private HashMap<String,Jumper> participants;
    
    public Jumper(String name)
    {
        this.name = name;
        this.points =  0;
        this.jumpLengths = new ArrayList<Integer>();
        this.participants = new HashMap<String,Jumper>();
    }
    
    public void add(String name)
    {
        participants.put(name, new Jumper(name));
    }
    
    public HashMap<String,Jumper> getJumpers()
    {
        return this.participants;
    }
    
    @Override
    public String toString()
    {
        return this.name + " (" + this.points + " points)";
    }
    
    public int getPoints()
    {
        return this.points;
    }
    
    public int jump()
    {
        this.random = new Random();
        
        int jumpLength = random.nextInt(120 - 60 +1) + 60;
        return jumpLength;
    }
    
    public int[] judgeScores()
    {
        this.judges = new int[5];
        for(int i = 0; i< judges.length; i++)
        {
            int judgeScore = random.nextInt(20 - 10 +1) + 10;
            judges[i] = judgeScore;//scores, unsorted
        }
        return judges;
    }
    public int jumpScore(int jumpLength, int[] judges)
    {
        sort(judges);//sorted
        //skip first and last:
        int score = jumpLength;
        for(int i = 1; i < judges.length-1; i++)//skips first and last index
        {
            score += judges[i];
        }
        return score;
    }
    public String printJudgesScores(int[] judges)
    {
        String judgesScores = "[";
        for(int i = 0; i < judges.length-1; i++)
        {
            judgesScores += judges[i] + ", ";
        }
        judgesScores += judges[judges.length-1] +"]";
        return judgesScores;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setPoints(int points)
    {
        this.points = points;
    }
    public int[] sort(int[] judges)
    {
        for(int i = 0; i < judges.length; i ++)
        {
            for(int j = i+1; j < judges.length;  j++)
            {
                if(judges[i] > judges[j])
                {
                    int temp = judges[i];
                    judges[i] = judges[j];
                    judges[j] = temp;
                }
            }
        }
        return judges;
    }
    
    public void addJumpLength(int jumpLength)
    {
        this.jumpLengths.add(jumpLength);
    }
    public String printJumpLengths()
    {
        String jumps = "jump lengths: ";
        for(int i = 0; i < this.jumpLengths.size()-1; i++)
        {
            jumps += this.jumpLengths.get(i) + " m, ";
        }
        jumps += this.jumpLengths.get(this.jumpLengths.size()-1) + " m";
        return jumps;
    }
}