package ca.bcit.comp2526.a2c;

import java.awt.Color;
import java.io.Serializable;

/**
 * Carnivore Class.
 * 
 * @author jaejang
 * @version 1.0
 */
public class Carnivore extends CellObject implements OmnivoreEdible, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4663745401342017218L;
    private final int maxLife = 7;
    private final int nummate = 1;
    private final int numempty = 2;
    private final int numfood = 2;
    
    /**
     * Constructor for the objects of Herbivore.
     * 
     * @param cell cell
     * @param type cell type
     */
    public Carnivore(Cell cell, TYPE type) {
        super(cell, type);
        resetLife = maxLife;
        life = maxLife;
        init();
    }

    @Override
    public void init() {
        cell.setBackground(Color.magenta);
        
    }

    @Override
    public void set(Cell location) {
        cell = location;
        
    }

    @Override
    public void turn() {
        giveBirth(nummate, numempty, numfood, life);
        move();
    }
    
    

}
