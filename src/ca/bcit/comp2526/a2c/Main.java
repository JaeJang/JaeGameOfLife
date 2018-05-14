package ca.bcit.comp2526.a2c;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Main Class. Game of Life The world simulation begins by placing Plants and
 * Herbivores (plant eaters) on a two-dimensional grid of Cells. The grid
 * displays the Plants (green) and Herbivores (yellow) by lling in the Cells
 * where they are found with the appropriate colour. Blank Cells represent empty
 * areas.
 * 
 * @author jaeja
 * @version 1.0
 */
public final class Main {

    /**
     * Size of World.
     */
    private static final int SIZEOFWORLD = 25;
    private static final Toolkit TOOLKIT;
    private static final float SCREENAREA = 0.80f;
    private static final float WIDHTPERCENTMAX = 100.0f; 

    static {
        TOOLKIT = Toolkit.getDefaultToolkit();
    }

    private Main() {
        
    }

    /**
     * Drives the program.
     * 
     * @param argv
     *            arguments
     */
    public static void main(final String[] argv) {
        final GameFrame frame;
        final World world;

        RandomGenerator.reset();
        world = new World(SIZEOFWORLD, SIZEOFWORLD);
        world.init();
        frame = new GameFrame(world);
        position(frame);
        frame.init();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        /*for(int i = 0; i < 600; i++) {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(i);
            frame.takeTurn();
        }*/
    }

    private static void position(final GameFrame frame) {
        final Dimension size;

        size = calculateScreenArea(SCREENAREA, SCREENAREA);
        frame.setSize(size);
        frame.setLocation(centreOnScreen(size));
    }

    /**
     * Get point of center of screen.
     * 
     * @param size
     *            dimension
     * @return point
     */
    public static Point centreOnScreen(final Dimension size) {
        final Dimension screenSize;

        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }

        screenSize = TOOLKIT.getScreenSize();

        return (new Point((screenSize.width - size.width) 
                / 2, (screenSize.height - size.height) / 2));
    }

    /**
     * Calculate screen area.
     * 
     * @param widthPercent
     *            widthPerecent
     * @param heightPercent
     *            heightPercent
     * @return area
     */
    public static Dimension calculateScreenArea(
            final float widthPercent, final float heightPercent) {
        final Dimension screenSize;
        final Dimension area;
        final int width;
        final int height;
        final int size;

        if ((widthPercent <= 0.0f) || (widthPercent > WIDHTPERCENTMAX)) {
            throw new IllegalArgumentException(
                    "widthPercent cannot be " 
                     + "<= 0 or > 100 - got: " + widthPercent);
        }

        if ((heightPercent <= 0.0f) || (heightPercent > WIDHTPERCENTMAX)) {
            throw new IllegalArgumentException(
                    "heightPercent cannot be " 
                     + "<= 0 or > 100 - got: " + heightPercent);
        }

        screenSize = TOOLKIT.getScreenSize();
        width = (int) (screenSize.width * widthPercent);
        height = (int) (screenSize.height * heightPercent);
        size = Math.min(width, height);
        area = new Dimension(size, size);

        return (area);
    }
}
