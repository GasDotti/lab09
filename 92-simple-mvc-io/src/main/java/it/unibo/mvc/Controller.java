package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;

    Controller() {
        final String path = System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt";
        this.currentFile = new File(path);
    }

    /**
     * Changes the current File.
     * 
     * @param path Where to find the new File.
     */
    public void setFile(final String path) {
        this.currentFile = new File(path);
    }

    /**
     * @return The current File.
     */
    public File getFile() {
        return this.currentFile;
    }

    /**
     * @return The String of the Path.
     */
    public String getFilePath() {
        return currentFile.toPath().toString();
    }

    /**
     * Writes a {@link String} in the current File.
     * 
     * @param s The String to be written.
     * @throws IOException Something happened during the File print.
     */
    public void saveString(final String s) throws IOException {
        try (PrintStream ps = new PrintStream(this.getFilePath(), StandardCharsets.UTF_8)) {
            ps.print(s);
        } catch (final IOException e) {
            e.printStackTrace(); // NOPMD: allowed as this is just an exercise
            throw new IOException(e);
        }
    }
}
