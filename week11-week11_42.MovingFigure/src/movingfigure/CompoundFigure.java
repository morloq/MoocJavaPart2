package movingfigure;

import java.awt.Graphics;
import java.util.*;
public class CompoundFigure extends Figure{
    
    private List<Figure> figures;
    
    public CompoundFigure()//position does not matter, values assigned do not matter
    {
        super(0, 0);
        this.figures = new ArrayList<Figure>();
    }
    
    public void add(Figure figure)
    {
        this.figures.add(figure);
    }
    
    @Override
    //draws itself by asking its parts to draw themselves.
    public void draw(Graphics graphics)
    {
        for(Figure f : figures)
        {
            f.draw(graphics);
        }
    }
    
    @Override
    public void move(int dx, int dy)
    {
        for(Figure f : figures)
        {
            f.move(dx, dy);
        }
    }
}