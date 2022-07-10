package dungeon;

import java.util.*;

public class Player {
    
    private int moves, height, length;
    private int x, y;
    private String[] playerMoves;
    private HashMap<Integer,Integer> movesRecorded;
    
    public Player(int moves, int height, int length)
    {
        this.moves = moves;
        this.x = 0;
        this.y = 0;
        this.height = height;
        this.length = length;
        this.movesRecorded = new HashMap<Integer,Integer>();
    }
    
    public HashMap<Integer,Integer> getMovesRecorded()
    {
        return this.movesRecorded;
    }
    
    public void updatePosition(String m)
    {
        
        char[] c = m.toCharArray();
        playerMoves = new String[c.length];
        for(int i = 0; i < c.length; i++)
        {
            playerMoves[i] = String.valueOf(c[i]);
        }
        
        for(String move : playerMoves)
        {
            if(move.equals("w") && y-1 >= 0)
            {
                this.y--;
            }
            if(move.equals("s") && y+1 <= height-1)
            {
                this.y++;
            }
            if(move.equals("a") && x-1 >= 0)
            {
                this.x--;
            }
            if(move.equals("d") && x+1 <= length-1)
            {
                this.x++;
            }
            HashMap<Integer,Integer> values = new HashMap<Integer,Integer>();
            values.put(x,y);
            movesRecorded.put(x,y);
        }
        moves--;
    }
    
    public int getMovesLeft()
    {
        return moves;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
}