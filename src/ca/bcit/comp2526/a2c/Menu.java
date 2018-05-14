package ca.bcit.comp2526.a2c;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Menu Class. You can save or load a world, quit the game or return to the game
 * with this menu class.
 * 
 * @author jaejang
 * @version 1.0
 */
public class Menu extends JPanel {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 3757905597650288984L;
    private JButton saveB;
    private JButton loadB;
    private JButton returnB;
    private JButton quitB;
    private GameFrame frame;
    private JTextField test;
    private JButton savedB;
    private final int width = 200;
    private final int height = 40;

    /**
     * Constructor of the object of Menu.
     * 
     * @param frame
     *            instance of GameFrame
     */
    public Menu(GameFrame frame) {

        this.frame = frame;

        saveB = new JButton("SAVE");
        saveB.addActionListener(new SaveListener());

        loadB = new JButton("LOAD");
        loadB.addActionListener(new LoadListener());

        returnB = new JButton("RETURN");
        returnB.addActionListener(new ReturnListener());

        quitB = new JButton("QUIT");
        quitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evnet) {
                System.exit(1);
            }
        });

        add(saveB);
        add(loadB);
        add(returnB);
        add(quitB);
    }

    /**
     * Add passed component such as JButton or JTextField to the panel.
     * 
     * @param component
     *            Component
     */
    public void addToPanel(JComponent component) {
        add(component);
        revalidate();
        repaint();
    }

    /**
     * When player clicks Save button, a textarea is appeared and it takes file
     * name. And it stores the world data in save folder 
     * with user typed name and
     * .dat extension.
     * 
     * @author jaeja
     * @version 1.0
     */
    private class SaveListener implements ActionListener {

        /**
         * This method performs the function.
         * 
         * @param event
         *            ActionEvent
         */
        public void actionPerformed(ActionEvent event) {
            test = new JTextField();
            test.setPreferredSize(new Dimension(width, height));
            savedB = new JButton("Save");
            savedB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String fileName = test.getText();
                    if (fileName.equals("")) {
                        return;
                    }
                    frame.save(fileName);
                    remove(test);
                    remove(savedB);
                    revalidate();
                    repaint();
                }
            });
            addToPanel(test);
            addToPanel(savedB);
        }
    }

    /**
     * When a player clicks Load Button, a list of saved files are appeared.
     * 
     * @author jaeja
     * @version 1.0
     */
    private class LoadListener implements ActionListener {

        /**
         * This method performs the function.
         * 
         * @param event
         *            ActionEvent
         */
        public void actionPerformed(ActionEvent event) {
            removeAll();
            File file = null;
            String[] paths;
            String name;
            file = new File("save/");
            paths = file.list();
            if (paths != null) {
                for (int i = 0; i < paths.length; i++) {
                    name = paths[i];
                    JButton button = new JButton(name);
                    button.addActionListener(new FileLoadListener(paths[i]));
                    addToPanel(button);
                }
            }
            addToPanel(returnB);

        }
    }

    /**
     * After player clicks Load button and a list is appeared, 
     * they can choose one
     * of saved file and continue to play.
     * 
     * @author jaejang
     * @version 1.0
     */
    private final class FileLoadListener implements ActionListener {
        private String name;

        /**
         * Constructor of the object of FileLoadListener.
         * 
         * @param name
         *            file name
         */
        private FileLoadListener(String name) {
            this.name = name;
        }

        /**
         * This method performs the function.
         * 
         * @param event
         *            ActionEvent
         */
        public void actionPerformed(ActionEvent event) {
            frame.load(name);
        }
    }

    /**
     * When player clicks Return button, they can go back to the game.
     * 
     * @author jaejang
     * @version 1.0
     */
    private class ReturnListener implements ActionListener {

        /**
         * This method performs the function.
         * 
         * @param event
         *            ActionEvent
         */
        public void actionPerformed(ActionEvent event) {
            frame.backtoGame();
        }
    }

    /*
     * private class QuitListener implements ActionListener { public void
     * actionPerformed(ActionEvent evnet) { System.exit(1); } }
     */

}
