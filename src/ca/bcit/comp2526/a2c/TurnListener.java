package ca.bcit.comp2526.a2c;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Listener Class.
 * 
 * @author jaejang
 * @version 1.0
 */
public class TurnListener extends MouseAdapter {

    /**
     * Where this listener class is going to be added.
     */
    private GameFrame gameframe;

    /**
     * Constructor for the object of TurnListener.
     * 
     * @param gameframe
     *            GameFrame
     */
    public TurnListener(GameFrame gameframe) {
        this.gameframe = gameframe;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gameframe.takeTurn();
    }
}
