package ca.bcit.comp2526.a2c;

import java.io.Serializable;

/**
 * World Class. Holds Cells and is where turns occurs
 * 
 * @author jaejang
 * @version 1.0
 */
public class World implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5496835667691362182L;
    private static final int MAXIMUMNUMBER = 99;
    private static final int PERCENTHERBIVORE = 80;
    private static final int PERCENTPLANT = 50;
    private static final int PERCENTCARNIVORE = 40;
    private static final int PERCENTOMNIVORE = 32;
    private Cell[][] cell;
    private int row;
    private int column;
    private int generatedNumber;

    /**
     * Constructor for the object of World.
     * 
     * @param rows
     *            number of rows
     * @param columns
     *            number of columns
     */
    public World(int rows, int columns) {
        this.row = rows;
        this.column = columns;
        cell = new Cell[column][row];
    }

    /**
     * Initialize the world.
     */
    public void init() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                cell[j][i] = new Cell(this, i, j);
                generatedNumber = RandomGenerator.nextNumber(MAXIMUMNUMBER);
                if (generatedNumber >= PERCENTHERBIVORE) {
                    cell[j][i].set(new Herbivore(cell[j][i], TYPE.HERBIVORE));
                } else if (generatedNumber >= PERCENTPLANT) {
                    cell[j][i].set(new Plant(cell[j][i], TYPE.PLANT));
                } else if (generatedNumber >= PERCENTCARNIVORE) {
                    cell[j][i].set(new Carnivore(cell[j][i], TYPE.CARNIVORE));
                } else if (generatedNumber >= PERCENTOMNIVORE) {
                    cell[j][i].set(new Omnivore(cell[j][i], TYPE.OMNIVORE));
                }
            }
        }
    }

    /**
     * Get specific cell.
     * 
     * @param y
     *            target row
     * @param x
     *            target column
     * @return cell
     */
    public Cell getCellAt(int y, int x) {
        return cell[x][y];
    }

    /**
     * Herbivore moves and Plant seeds when turns over.
     */
    public void takeTurn() {
        CellObject temp = null;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                cell[c][r].setMoved(false);
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (!cell[c][r].getMoved()) {
                    temp = cell[c][r].get();
                    if (temp != null) {
                        temp.turn();
                    }
                }
            }
        }
    }

    /**
     * get number of rows.
     * 
     * @return row
     */
    public int getRowCount() {
        return row;
    }

    /**
     * get number of column.
     * 
     * @return column
     */
    public int getColumnCount() {
        return column;
    }

}
