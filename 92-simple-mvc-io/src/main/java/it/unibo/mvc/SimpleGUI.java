package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;

    private final JFrame frame = new JFrame("SimpleGUI");

    /**
     * Constructor: Prepares the SimpleGUI object.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel(new BorderLayout());

        final JTextArea txt = new JTextArea();
        canvas.add(txt, BorderLayout.CENTER);
        final JButton btnSave = new JButton("Save");
        canvas.add(btnSave, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Sets up the frame and makes it visible.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int newWidth = screen.width / PROPORTION;
        final int newHeight = screen.height / PROPORTION;

        frame.setSize(new Dimension(newWidth, newHeight));
        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    /**
     * Starts the GUI by making an object and displaying it.
     * 
     * @param args ignored.
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }

}
