package ca.bcit.comp2526.a2c;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * KeyListener Class. When user presses ESC, it changes display to menu.
 * 
 * @author jaejang
 * @version 1.0
 */
public class KeyListener extends KeyAdapter {

    private GameFrame gameframe;

    /**
     * Constructor of the object of KeyListener.
     * 
     * @param gameframe
     *            instance of GameFrame.
     */
    public KeyListener(GameFrame gameframe) {
        this.gameframe = gameframe;
    }

    /**
     * When user presses ESC, it changes display to menu.
     * 
     * @param e
     *            KeyEvent
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            gameframe.changeToMenu();
        }

    }

}
