package wormgame.gui;

import wormgame.domain.Worm;
import wormgame.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener{
    
    private final Worm worm;
    
    public KeyboardListener(Worm worm)
    {
        this.worm = worm;
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
    
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
       int keyCode = e.getKeyCode();
       switch(keyCode){
           case KeyEvent.VK_UP:
               worm.setDirection(Direction.UP);
               break;
           case KeyEvent.VK_DOWN:
               worm.setDirection(Direction.DOWN);
               break;
           case KeyEvent.VK_LEFT:
               worm.setDirection(Direction.LEFT);
               break;
           case KeyEvent.VK_RIGHT:
               worm.setDirection(Direction.RIGHT);
               break;
           default:
               //what? to? do?
       }
    }
    
    @Override public void keyTyped(KeyEvent e)
    {
    
    }
}