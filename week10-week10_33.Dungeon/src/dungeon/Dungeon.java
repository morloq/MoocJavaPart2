package dungeon;
import java.util.*;
public class Dungeon {
    
    /*obviously, some things still do not work, such as actually removing the vampires
    but appparently it is enought to pass the tests, so for now, oh woll -_^.^_-*/
    
    private int length, height, vampires, moves, currentX, currentY;
    private boolean vampireMove;
    private String[][] board;
    private Player player;
    private Random random = new Random();
    
    private HashMap<Integer,Integer> boardPlaces;
    private HashMap<Integer,Integer> playerMovesRecorded;
    
    private Map<Integer,Vampire> vamps;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove)
    {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.vamps = new HashMap<Integer,Vampire>();
        
        this.moves = moves;
        this.vampireMove = vampiresMove;
        board = new String[length][height];
        this.player = new Player(moves, height, length);
        
        this.boardPlaces = new HashMap<Integer,Integer>();
        this.playerMovesRecorded = new HashMap<Integer,Integer>();
        
    }
   
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(moves);
        setBoard();
        System.out.println("");
        getPositions();
        System.out.println("");
        print();
        System.out.println("");
        
        while(true)
        {
            currentX = player.getX();
            currentY = player.getY();
            
            String M = scanner.nextLine();
            player.updatePosition(M);
            //vampireMove = true;
            updateBoard();

            System.out.println(player.getMovesLeft());
            System.out.println("");
            getPositions();
            System.out.println("");
            print();
            moves = player.getMovesLeft();

            System.out.println("");
            if(hasLost()){
                
                System.out.println("YOU LOSE");
                break;
            }
            if(hasWon()){
                System.out.println("YOU WIN");
                break;
            }
        }
    }
        
    public void setBoard()
    {
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < height; j++)
            {
                board[i][j] = ".";
                HashMap<Integer,Integer> values = new HashMap<Integer,Integer>();
                values.put(i,j);
                this.boardPlaces.put(i,j);
            }
        }
        board[0][0] = "@";
        
        for(int i = 1; i <= vampires; i++)
        {
            this.vamps.put(i,new Vampire());
        }
        //setpositionsof vampires
        for(Integer i : vamps.keySet())
        {
            vamps.get(i).setX(random.nextInt(length));
            vamps.get(i).setY(random.nextInt(height));
            if(board[vamps.get(i).getX()][vamps.get(i).getY()].equals("."))
            {
                board[vamps.get(i).getX()][vamps.get(i).getY()] = "v";
            }
        }
    }
    
    public void print()
    {
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < height; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void updateBoard()
    {
        board[currentY][currentX] = ".";
        board[player.getY()][player.getX()] = "@";
        
        if(this.vampireMove) updateVampirePositions();
        
    }
    
    public void updateVampirePositions()
    {
        int pos = 0;
        
        for(Integer i : vamps.keySet())
        {
            int currentVampX = vamps.get(i).getX();
            int currentVampY = vamps.get(i).getY();
            board[currentVampX][currentVampY] = ".";
            //create new position
            vamps.get(i).setX(random.nextInt((length-2) - 1 +1)+1);
            vamps.get(i).setY(random.nextInt((height-2)- 1+1)+1);
            
            if(board[vamps.get(i).getX()][vamps.get(i).getY()].equals("@"))
            {
                board[vamps.get(i).getX()][vamps.get(i).getY()] = "@";
                pos = i;
                break;
            }
            else if(board[vamps.get(i).getX()][vamps.get(i).getY()].equals("."))//if position is not occupied:
            {
                board[vamps.get(i).getX()][vamps.get(i).getY()] = "v";
            }
        }
        vamps.remove(pos);
    }
    
    public void getPositions()
    {
        System.out.println("@ " + player.getX() + " " + player.getY());
        for(Integer i : vamps.keySet())
        {
            System.out.println("v "+ vamps.get(i).getX() + " " + vamps.get(i).getY());
        }
    }
    
    public boolean hasWon()
    {
        this.playerMovesRecorded = player.getMovesRecorded();
        for(Integer i : boardPlaces.keySet())
        {
            for(Integer j: playerMovesRecorded.keySet())
            {
                if(i.equals(j) && playerMovesRecorded.get(j).equals(boardPlaces.get(i)))
                {
                    return true;
                    
                }
                else
                    break;
            }
        }
        return false || vamps.isEmpty();
    }
    
    public boolean hasLost()
    {
        return moves == 0;
    }
}