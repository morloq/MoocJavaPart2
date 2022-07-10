package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable{
    
    private WormGame wormGame;
    private int pieceLength;
    
    public DrawingBoard(WormGame wormGame, int pieceLength)
    {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;//dimension of pieces, pieces are squares.
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //draw worm using fill3DRect, has to be black: Color.BlACK
        Worm worm = wormGame.getWorm();
        Apple apple = wormGame.getApple();
        
        g.setColor(Color.BLACK);
        
        List<Piece> pieces = worm.getPieces();
        for(Piece p: pieces)
        {
            //draw each piece
            g.fill3DRect(p.getX()*pieceLength, p.getY()*pieceLength, pieceLength, pieceLength, true);
        }
        
        //draw apple using fillOval, has to be red: Color.RED;
        g.setColor(Color.RED);
        g.fillOval(apple.getX()*pieceLength, apple.getY()*pieceLength, pieceLength, pieceLength);
    }

    @Override
    public void update()
    {
        super.repaint();
    }
}