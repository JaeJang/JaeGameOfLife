package ca.bcit.comp2526.a2c;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;

/**
 * GameFrame.
 * 
 * @author jaejang
 * @version 1.0
 */
public class GameFrame extends JFrame implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private World world;

    /**
     * Constructor for the object of GameFrame.
     * 
     * @param w
     *            world
     */
    public GameFrame(final World w) {
        world = w;

        setTitle("Assignment 2a");
        addMouseListener(new TurnListener(this));
        addKeyListener(new KeyListener(this));
    }

    /**
     * SetLayout and add all cells to frame.
     */
    public void init() {
        setLayout(new GridLayout(
                world.getRowCount(), world.getColumnCount(), -1, -1));
                

        for (int row = 0; row < world.getRowCount(); row++) {
            for (int col = 0; col < world.getColumnCount(); col++) {
                add(world.getCellAt(row, col));
            }
        }

    }

    /**
     * Make changes when the turn goes on.
     */
    public void takeTurn() {
        world.takeTurn();
        repaint();
    }

    /**
     * Change display to menu when user presses ESC.
     */
    public void changeToMenu() {
        Menu menu = new Menu(this);
        getContentPane().removeAll();
        add(menu);
        revalidate();
        repaint();
    }

    /**
     * Back to the game.
     */
    public void backtoGame() {
        getContentPane().removeAll();
        init();
        setFocusable(true);
        requestFocus();
        revalidate();
        repaint();
    }

    /**
     * Save a world to dat file.
     * 
     * @param name
     *            file name
     */
    public void save(String name) {
        ObjectOutputStream out = null;
        String fileName = "save/" + name + ".dat";
        File thefile = new File("save");
        thefile.mkdirs();
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(world);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Load saved world so player plays continue.
     * 
     * @param name
     *            file name
     */
    public void load(String name) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("save/" + name));
            world = (World) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        backtoGame();
    }
}
