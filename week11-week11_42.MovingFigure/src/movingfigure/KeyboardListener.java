package movingfigure;

import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyboardListener implements KeyListener{
    
    private Component component;
    private Figure figure;
    
    public KeyboardListener(Component component, Figure figure)
    {
        this.component = component;
        this.figure = figure;
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            figure.move(-1, 0);//1 to the left
            component.repaint();//why?
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            figure.move(+1, 0);//1 to the right
            component.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            figure.move(0, -1);//1 to the top
            component.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            figure.move(0, +1);//1 to the bottom
            component.repaint();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}