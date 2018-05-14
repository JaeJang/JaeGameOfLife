package ca.bcit.comp2526.a2c;

import java.awt.Color;
import java.io.Serializable;

/**
 * Omnivore Class.
 * 
 * @author jaejang
 * @version 1.0
 */
public class Omnivore extends CellObject implements CarnivoreEdible, Serializable  {
    /**
     * 
     */
    private static final long serialVersionUID = -4624881857896183793L;
    private final int maxLife = 2;
    private final int nummate = 1;
    private final int numempty = 3;
    private final int numfood = 3;
    
    /**
     * Constructor for the objects of Herbivore.
     * 
     * @param cell cell
     * @param type cell type
     */
    public Omnivore(Cell cell, TYPE type) {
        super(cell, type);
        resetLife = maxLife;
        life = maxLife;
        init();
    }

    @Override
    public void init() {
        cell.setBackground(Color.blue);
        
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
