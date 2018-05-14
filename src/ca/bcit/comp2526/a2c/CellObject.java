package ca.bcit.comp2526.a2c;

import java.io.Serializable;
import java.util.Random;

/**
 * Super class of Herbivore and plant.
 * 
 * @author jaejang
 * @version 1.0
 */
public abstract class CellObject implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8948489222095974732L;

    /**
     * Cell.
     */
    protected Cell cell;

    /**
     * Type of cell.
     */
    protected TYPE type;

    /**
     * Adjacent cells.
     */
    protected Cell adjCell[];
    
    /**
     * current life.
     */
    protected int life;
    
    /**
     * reset life to initial.
     */
    protected int resetLife;
    
    
    private Random r = new Random();
    

    /**
     * Contructor for the objects of CellObjects.
     * 
     * @param cell
     *            cell
     * @param type
     *            type
     */
    public CellObject(Cell cell, TYPE type) {
        this.cell = cell;
        this.type = type;
    }

    /**
     * Initialize of specific cell.
     */
    public abstract void init();

    /**
     * Set cell to the other cell.
     * 
     * @param location
     *            cell
     */
    public abstract void set(Cell location);
    
    /**
     * Get moved.
     */
    public abstract void turn();
    
    /**
     * get cell type.
     * 
     * @return type
     */
    public TYPE getType() {
        return type;
    }
    
    
    /**
     * Seed when the conditions are satisfied.
     * 
     * @param nummate number of mate
     * @param numempty number of empty
     * @param numfood number of food
     * @param life current life
     */
    public void giveBirth(final int nummate, 
            final int numempty, final int numfood, final int life) {
        if (life > 1) {
            final int len;
            int countEmpty = 0; 
            int countFood = 0;
            int countMate = 0;
            DoubleLinkedList<Cell> emptyCell = new DoubleLinkedList<Cell>();
            Cell tempCell;
            CellObject tempObject;
            
            adjCell = cell.getAdjacentCells();
            len = adjCell.length;
            for (int i = 0; i < len; i++) {
                tempObject = adjCell[i].get();
                if (tempObject != null) {
                    if (checkInstance(tempObject)) {
                        countFood++;                    
                    } else if (tempObject.getType() == type) {
                        countMate++;
                    }
                }
                if (tempObject == null) {
                    try {
                        emptyCell.addToFront(adjCell[i]);
                    } catch (CouldNotAddException e) {
                        e.printStackTrace();
                    }
                    countEmpty++;
                }
                
            }
            if (countMate >= nummate && countEmpty >= numempty 
                    && countFood >= numfood) {
                tempCell = emptyCell.get(r.nextInt(countEmpty));
                tempCell.set(makeNew(tempCell));
                tempCell.setMoved(true);
            }
        } else {
            return;
        }
        
    }
    
    /**
     * Make this move toward their food.
     */
    public void move() {
        CellObject tempObject = null;
        adjCell = cell.getAdjacentCells();
        
        if (life > 1) {
            final int len = adjCell.length;
            DoubleLinkedList<Cell> destCells = new DoubleLinkedList<Cell>();
            DoubleLinkedList<Cell> emptyCell = new DoubleLinkedList<Cell>();
            Cell destinationCell = null;
            
            for (int i = 0; i < len; i++) {
                tempObject = adjCell[i].get();
                if (tempObject != null) {
                    if (checkInstance(tempObject)) {
                        try {
                            destCells.addToFront(adjCell[i]);
                        } catch (CouldNotAddException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (destCells.size() == 0 && tempObject == null) {
                    try {
                        emptyCell.addToFront(adjCell[i]);
                    } catch (CouldNotAddException e) {
                        e.printStackTrace();
                    }                    
                }
            }
            if (destCells.size() > 0 || emptyCell.size() > 0) {
                if (destCells.size() == 0) {
                    destinationCell = 
                            emptyCell.get(r.nextInt(emptyCell.size()));
                    
                    life--;
                } else if (destCells.size() >= 1) {
                    destinationCell = 
                            destCells.get(r.nextInt(destCells.size()));
                    life = resetLife;
                }
                destinationCell.set(this);
                destinationCell.setMoved(true);
                resetCell();
                set(destinationCell);
                init();                
            }
        } else {
            resetCell();
        }
    }
    
    /**
     * Reset the cell to default.
     */
    public void resetCell() {
        cell.remove();
        cell.init();
    }
    
    /**
     * return true if the adjacent cell is 
     * a food of this cell.
     * 
     * @param objectCheck adjacent cell
     * @return boolean
     */
    private boolean checkInstance(CellObject objectCheck) {
        /*if(type == TYPE.PLANT) {
            return objectCheck instanceof PlantSeed;
        } else*/ if (type == TYPE.HERBIVORE) {
            return objectCheck instanceof HerbivoreEdible;
        } else if (type == TYPE.CARNIVORE) {
            return objectCheck instanceof CarnivoreEdible;
        } else if (type == TYPE.OMNIVORE) {
            return objectCheck instanceof OmnivoreEdible;
        }
        return false;
    }
    
    /**
     * Make new instance.
     * 
     * @param location destination cell
     * @return CellObject
     */
    private CellObject makeNew(Cell location) {
        if (type == TYPE.PLANT) {
            return new Plant(location, TYPE.PLANT);
        } else if (type == TYPE.HERBIVORE) {
            return  new Herbivore(location, TYPE.HERBIVORE);
        } else if (type == TYPE.CARNIVORE) {
            return new Carnivore(location, TYPE.CARNIVORE);
        } else if (type == TYPE.OMNIVORE) {
            return new Omnivore(location, TYPE.OMNIVORE);
        }
        return null;
    }

}
