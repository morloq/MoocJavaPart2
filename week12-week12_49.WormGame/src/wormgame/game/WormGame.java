package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private Worm worm;
    private Apple apple;
    private Random random;
    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;

    public WormGame(int width, int height) {
        super(1000, null);
        
        this.width = width;
        this.height = height;
        this.continues = true;

        this.random = new Random();
        int appleX = random.nextInt(width);
        int appleY = random.nextInt(height);
        
        int wormX = width/2;
        int wormY = height/2;
        
        this.worm = new Worm(wormX, wormY, Direction.DOWN);
        
        while(appleX == wormX && appleY == wormY)
        {
            appleX = random.nextInt(width);
            appleY = random.nextInt(height);
        }
        
        this.apple = new Apple(appleX, appleY);
        
        /*x coordinate has to be contained between [0, width[, and the y coordinate between [0, height[*/
        
        
        
        addActionListener(this);
        setInitialDelay(2000);
    }

    public Worm getWorm()
    {
        return this.worm;
    }
    
    public void setWorm(Worm worm)
    {
        this.worm = worm;
        //worm = getWorm();//would that work as well?
        
    }
    
    public Apple getApple()
    {
        return this.apple;
    }
    
    public void setApple(Apple apple)
    {
        this.apple = apple;
    }
    
    
    
    
    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            //move worm
            worm.move();
            //if runs into apple, eat apple, grow, create new apple randomly
            if(worm.runsInto(apple))
            {
                worm.grow();
                setApple(new Apple(random.nextInt((width -1) - 0 +1),(height -1 ) - 0 +1));
            }
            //if worm runs into itself continue = false
            if(worm.runsIntoItself() || wormHitsBorder())
            {
                continues = false;
            }
            //call update method
            updatable.update();
            //call setDelay method setDelay(1000/worm.getLength()); if worm has been defined
            setDelay(1000/worm.getLength());
        }
    }
    
    public boolean wormHitsBorder()
    {
        Piece head = worm.getHead();
        if(head.getX() >= width || head.getX() <= 0){return true;}
        
        else if(head.getY() >= height || head.getY() <= 0){return true;}
        else
            return false;
    }
}