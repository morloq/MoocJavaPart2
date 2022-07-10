package movingfigure;

import java.awt.Graphics;

abstract public class Figure {
    
    protected int x;
    protected int y;
    
    public Figure(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public void move(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }
    
    public abstract void draw(Graphics graphics);//is implemented in class that inherits figure
}