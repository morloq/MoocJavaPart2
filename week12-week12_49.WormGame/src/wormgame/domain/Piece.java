/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author Admin
 */
public class Piece {
    
    protected int x,y;
    
    public Piece(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean runsInto(Piece pice)
    {
        //true if piece constructer coordinates equal pieces coordinates
        if(this.x == pice.getX() && this.y == pice.getY()) return true;
        else return false;
    }
    
    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}