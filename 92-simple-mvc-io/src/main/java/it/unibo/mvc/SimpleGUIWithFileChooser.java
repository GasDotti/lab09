package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 4;

    private final JFrame frame = new JFrame();
    private final Controller c = new Controller();
    private final JFileChooser selection = new JFileChooser(System.getProperty("user.home"));

    /**
     * Constructor: Prepares the SimpleGUIWithFileChooser object.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel(new BorderLayout());

        final JButton btnSave = new JButton("Save");
        canvas.add(btnSave, BorderLayout.SOUTH);
        final JTextArea txt = new JTextArea();
        canvas.add(txt, BorderLayout.CENTER);

        final JPanel northBox = new JPanel(new BorderLayout());
        final JLabel fileLabel = new JLabel(c.getFile().getName());
        northBox.add(fileLabel, BorderLayout.CENTER);
        final JButton btnBrowse = new JButton("Browse...");
        northBox.add(btnBrowse, BorderLayout.LINE_END);

        canvas.add(northBox, BorderLayout.NORTH);
        frame.add(canvas);

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

        btnBrowse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                selection.setFileSelectionMode(JFileChooser.FILES_ONLY);

                switch (selection.showSaveDialog(frame)) {
                    case JFileChooser.APPROVE_OPTION:
                        c.setFile(selection.getSelectedFile().getPath());
                        fileLabel.setText(c.getFile().getName());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;

                    default:
                        JOptionPane.showMessageDialog(btnBrowse, "An error has occured.");
                        break;
                }
            }
        });
    }

    /**
     * Sets up the frame and makes it visible.
     */
    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int newWidth = screen.width / PROPORTION;
        final int newHeight = screen.height / PROPORTION;

        frame.setSize(newWidth, newHeight);
        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    /**
     * Starts the GUI by making an object and displaying it.
     * 
     * @param args ignored.
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }
}
