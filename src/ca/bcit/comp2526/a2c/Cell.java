package ca.bcit.comp2526.a2c;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Cell Class which contains a herbivore or a plant or nothing.
 * 
 * @author jaejang
 * @version 1.0
 */
public class Cell extends JPanel implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5176651482405044837L;
    private int row;
    private int column;
    private boolean moved;
    private final World world;
    private CellObject cellobject;

    /**
     * Constructor for the object of Cell.
     * 
     * @param world
     *            world
     * @param row
     *            Y position
     * @param column
     *            x position
     */
    public Cell(World world, int row, int column) {
        this.world = world;
        this.row = row;
        this.column = column;
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        init();
    }

    /**
     * Initial color.
     */
    public void init() {
        setBackground(Color.white);
    }

    /**
     * Returns Cell array which is consist of adjacent cells.
     * 
     * @return cell[]
     */
    public Cell[] getAdjacentCells() {
        
        ArrayList<Cell> cellAryList = new ArrayList<Cell>();
        Cell temp = null;
        for (int r = -1; r < 2; r++) {
            for (int c = -1; c < 2; c++) {
                if (r != 0 || c != 0) {
                    try {
                        temp = world.getCellAt(row + r, column + c);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        temp = null;
                    }
                    if (temp != null) {
                        cellAryList.add(temp);

                    }
                }
            }
        }
        Cell[] cell = (Cell[]) cellAryList.toArray(
                new Cell[cellAryList.size()]);
        return cell;
    }

    /**
     * Get positions of the cell.
     * 
     * @return point point
     */
    public Point getLocation() {
        return new Point(column, row);
    }

    /**
     * Set instance of CellObject to Herbivore or Plant.
     * 
     * @param cellObject
     *            cellObject
     */
    public void set(CellObject cellObject) {
        this.cellobject = cellObject;
    }

    /**
     * Get instance of CellObject.
     * 
     * @return cellobject
     */
    public CellObject get() {
        return cellobject;
    }

    /**
     * Set this cell to empty.
     */
    public void remove() {
        cellobject = null;
    }

    /**
     * True if this cell is a result from moving of Herbivore or Plant.
     * 
     * @param moved
     *            moved
     */
    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    /**
     * Get moved.
     * 
     * @return moved
     */
    public boolean getMoved() {
        return moved;
    }

}
