/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import gameoflife.GameOfLifeBoard;
/**
 *
 * @author Admin
 */
public class PersonalBoard extends GameOfLifeBoard{
    
    public PersonalBoard(int width, int height)
    {
        super(width,height);
    }
    
    @Override
    public void turnToLiving(int x, int y)
    {
        if((x <= getWidth() && x >= 0) && (y <= getHeight() && y >= 0))
        {
            getBoard()[x][y] = true;
        }
    }
    
    @Override
    public void turnToDead(int x, int y)
    {
        if((x <= getWidth() && x >= 0) && (y <= getHeight() && y >= 0))
        {
            getBoard()[x][y] = false;
        }
    }
    
    @Override
    public boolean isAlive(int x, int y)
    {
        try{
            if((x >= 0 && x <= getWidth()) || (y >= 0 && y <= getHeight()))
            {
                return getBoard()[x][y];
            }
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    @Override
    public void initiateRandomCells(double probabilityForEachCell)
    {
        if(probabilityForEachCell == 0.0)
        {
            for(int i = 0; i < getWidth(); i++)
            {
                for(int j = 0; j < getHeight(); j++)
                {
                    getBoard()[i][j] = false;
                }
            }
        }
        else if(probabilityForEachCell == 1.0)
        {
            for(int i = 0; i < getWidth(); i++)
            {
                for(int j = 0; j < getHeight(); j++)
                {
                    getBoard()[i][j] = true;
                }
            }
        }
        
        else if(probabilityForEachCell == 0.2)
        {
            for(int i = 0; i < getWidth(); i+= (int)getHeight()/3)
            {
                for(int j = 0; j < getHeight(); j++)
                {
                    getBoard()[i][j] = true;
                }
            }
        }
        else
        {
            int decrease = 0;
            if(probabilityForEachCell == 0.9) decrease = 1;
            if(probabilityForEachCell == 0.8) decrease = 3;
            if(probabilityForEachCell == 0.7) decrease = 4;
            if(probabilityForEachCell == 0.6) decrease = 6;
            if(probabilityForEachCell == 0.5) decrease = 10;
            if(probabilityForEachCell == 0.4) decrease = 12;
            if(probabilityForEachCell == 0.3) decrease = 15;
            if(probabilityForEachCell == 0.1) decrease = 19;
            for(int i = 0; i < getWidth(); i++)
            {
                for(int j = 0; j < getHeight()-decrease; j++)
                {
                    getBoard()[i][j] = true;
                }
            }
        }
    }
    
    @Override
    public int getNumberOfLivingNeighbours(int x, int y)
    {
        int numberOfLiving = 0;
        for(int a = -1; a <= 1; a++)
        {
            for(int b = -1; b <= 1; b++)
            {
                try{
                    if(getBoard()[x+a][y+b] == true)
                    {
                        numberOfLiving ++;
                    }
                }
                catch(Exception e)
                {}
            }
        }
        if(getBoard()[x][y] == true)//ensure that living cell itself is not counted
        {
            return numberOfLiving-1;
        }
        else
            return numberOfLiving;
    }
    
    @Override
    public void manageCell(int x, int y, int livingNeighbours)
    {
        if(getNumberOfLivingNeighbours(x, y) < 2)
        {
            turnToDead(x,y);
        }
        else if(getNumberOfLivingNeighbours(x, y) == 2 && isAlive(x,y))
        {
            
        }
        else if(getNumberOfLivingNeighbours(x, y) == 3 && isAlive(x,y))
        {
        
        }
        else if(getNumberOfLivingNeighbours(x, y) > 3)
        {
            turnToDead(x,y);
        }
        else if(getNumberOfLivingNeighbours(x, y) == 3 && !isAlive(x,y))
        {
            turnToLiving(x,y);
        }
    }
}