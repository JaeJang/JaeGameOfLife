package ca.bcit.comp2526.a2c;

import java.awt.Color;
import java.io.Serializable;

/**
 * Herbivore Class.
 * 
 * @author jaejang
 * @version 1.0
 */
public class Herbivore extends CellObject implements CarnivoreEdible, OmnivoreEdible, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 5413747688451713430L;
    private final int maxLife = 10;
    private final int NUM_MATE = 2;
    private final int NUM_EMPTY = 1;
    private final int NUM_FOOD = 2;
    
    /**
     * Constructor for the objects of Herbivore.
     * 
     * @param cell cell
     * @param type cell type
     */
    public Herbivore(Cell cell, TYPE type) {
        super(cell, type);
        resetLife = maxLife;
        life = maxLife;
        init();
    }

    @Override
    public void init() {
        cell.setBackground(Color.yellow);
    }
    
    @Override
    public void set(Cell location) {
        this.cell = location;
    }
    
    /**
     * Make this herbivore move toward plant.
     */
    public void turn() {
        giveBirth(NUM_MATE, NUM_EMPTY, NUM_FOOD, life);
        move();
        /*CellObject tempObject = null;
        adjCell = cell.getAdjacentCells();
        
        if (life > 1) {
            final int len = adjCell.length;
            ArrayList<Cell> destCells = new ArrayList<Cell>();
            ArrayList<Cell> emptyCell = new ArrayList<Cell>();
            Cell destinationCell = null;
            
            for (int i = 0; i < len; i++) {
                tempObject = adjCell[i].get();
                if (tempObject != null) {
                    if (tempObject.getType() == TYPE.PLANT) {
                        destCells.add(adjCell[i]);
                    }
                }
                if (destCells.size() == 0 && tempObject == null) {
                    emptyCell.add(adjCell[i]);                    
                }
            }
            
            if (destCells.size() == 0) {
                destinationCell = emptyCell.get(r.nextInt(emptyCell.size()));
                life--;
            } else if (destCells.size() >= 1) {
                destinationCell = destCells.get(r.nextInt(destCells.size()));
                life = maxLife;
            }
            destinationCell.set(this);
            destinationCell.setMoved(true);
            resetCell();
            set(destinationCell);
            init();
        } else {
            resetCell();
        }*/
    }
    
    
    

}
