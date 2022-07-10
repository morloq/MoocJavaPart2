package wormgame.domain;
import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

public class Worm{
    
    private final int x, y;
    private Direction originalDirection;
    private final List<Piece> worm;
    private boolean shouldGrow;
    
    public Worm(int originalX, int originalY, Direction originalDirection)
    {
        this.x = originalX;
        this.y = originalY;
        this.originalDirection = originalDirection;
        worm = new ArrayList<Piece>();
        worm.add(new Piece(originalX,originalY));
    }
    
    public Direction getDirection()
    {
        return originalDirection;
    }
    
    public void setDirection(Direction dir)
    {
        this.originalDirection = dir;
    }
    
    public int getLength()
    {
        return getPieces().size();
    }
    
    public List<Piece> getPieces()
    {   
        return worm;
    }
    
    public Piece getHead()
    {
        return worm.get(getLength()-1);//because index starts at 0
    }
    
    public void move()
    {
        int newX = worm.get(worm.size()-1).getX();
        int newY = worm.get(worm.size()-1).getY();
        if(getLength() == 1 || getLength() == 2)
        {
            shouldGrow = false;
        }
        switch(originalDirection)
        {
            case UP:
                newY -= 1;
                break;
            case DOWN:
                newY += 1;
                break;
            case LEFT:
                newX -= 1;
                break;
            case RIGHT:
                newX += 1;
                break;
            default:
                throw new RuntimeException();
        }
        
        if(getLength() > 2 && !shouldGrow)
        {
            worm.remove(0);
            //shouldGrow = false;
        }
        if(getLength() > 2)
        {
            shouldGrow = false;
        }
        worm.add(new Piece(newX,newY));
    }
    
    public void grow()
    {
        
        shouldGrow = true;
    }
    
    public boolean runsInto(Piece piece)
    {
        for(Piece p : worm)
        {
            boolean piecelocation = p.getX() == piece.getX() && p.getX() == piece.getX();
            if(piecelocation && !p.equals(piece))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself()
    {
        Piece head = worm.get(getLength()-1);
        return runsInto(head);
    }   
}