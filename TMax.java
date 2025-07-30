import java.io.*;

/**
 * TMax is a thread that reads a file containing integers (one per line)
 * and determines the maximum value in that file.
 */
public class TMax extends Thread {

    private File file;
    private int max = 0;

    public TMax(File file) {
        this.file = file;
    }

    public int getMax() {
        return max;
    }

    public String getFileName() {
        return file.getName();
    }

    public void read() {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                int value = Integer.parseInt(line);
                if (value > max) {
                    max = value;
                }
            }

            System.out.println("Done scanning " + file.getName());
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println("Starting scan on " + this.file.getName());
        read();
    }
}
