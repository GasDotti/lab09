package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;

    private final JFrame frame = new JFrame("SimpleGUI");
    private final Controller c = new Controller();

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

        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    c.saveString(txt.getText());
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(btnSave, ex);
                }
            }
        });
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

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
