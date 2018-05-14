package ca.bcit.comp2526.a2c;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Plant Class.
 * Seed when there are at least two Plant around
 * and at least three empty cell around.
 * 
 * @author jaejang
 * @version 1.0
 */
public class Plant extends CellObject implements PlantSeed, HerbivoreEdible, OmnivoreEdible, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6045305053804621416L;
    private final int NUM_PLANT = 2;
    private final int NUM_EMPTY = 3;
    
    /**
     * Constructor for the object of Plant.
     * 
     * @param cell occupied cell
     * @param type cell type
     */
    public Plant(Cell cell, TYPE type) {
        super(cell, type);
        init();
    }
    
    /**
     * Occupy a new cell.
     * 
     * @param location cell
     */
    public void set(Cell location) {
        this.cell = location;
    }
    @Override
    public void init() {
        cell.setBackground(Color.green);
    }
    
    /**
     * Seed when the conditions are satisfied.
     */
    public void turn() {
        giveBirth(NUM_PLANT,NUM_EMPTY,0, 10);
        /*final int len;
        int numberOfE = 0; 
        int numberOfP = 0;
        Random r = new Random();
        ArrayList<Cell> emptyCell = new ArrayList<Cell>();
        Cell tempCell;
        CellObject tempObject;
        
        adjCell = cell.getAdjacentCells();
        len = adjCell.length;
        for (int i = 0; i < len; i++) {
            tempObject = adjCell[i].get();
            if (tempObject != null && tempObject.getType() == TYPE.PLANT) {
                numberOfP++;
            }
            if (tempObject == null) {
                emptyCell.add(adjCell[i]);
                numberOfE++;
            }
        }
        if (numberOfE >= NUM_EMPTY && numberOfP >= NUM_PLANT) {
            tempCell = emptyCell.get(r.nextInt(numberOfE));
            tempCell.set(new Plant(tempCell, TYPE.PLANT));
        }*/
    }
    
    

}
