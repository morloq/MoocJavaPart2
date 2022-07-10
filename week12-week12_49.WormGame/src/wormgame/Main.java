package wormgame;

import javax.swing.SwingUtilities;
import wormgame.gui.UserInterface;
import wormgame.game.WormGame;
import wormgame.domain.*;

public class Main {

    public static void main(String[] args) {
        Worm worm = new Worm(5, 5, Direction.RIGHT);
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());

        worm.grow();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());

        worm.setDirection(Direction.LEFT);
        System.out.println(worm.runsIntoItself());
        worm.move();
        System.out.println(worm.runsIntoItself());
    }
}