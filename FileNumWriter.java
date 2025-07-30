import java.io.*;

/**
 * FileNumWriter is a thread that generates a file filled with
 * 1,000,000 random integers ranging from 1 to 1,000,000,000.
 * Each thread writes to its own file with a given name.
 */
public class FileNumWriter extends Thread {

    private String name;
    private File file;

    public FileNumWriter(String name) {
        this.name = name;
        this.file = new File(name + ".txt");
    }

    public File getFile() {
        return file;
    }

    public boolean createFile() {
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return false;
        }
    }

    public void writeNumber() {

        try {

            FileWriter writer = new FileWriter(file);
            System.out.println("Writing numbers to " + this.name + ".txt ...");

            for (int i = 0; i < 1000000; i++) {

                int randomNum = (int) ((Math.random() * 1000000000) - 1) + 1;
                writer.write(randomNum + "\n");

            }

            System.out.println(this.name + ".txt generation complete.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (createFile()) {
            System.out.println("File created: " + this.name + ".txt");
        } else {
            System.out.println("File exists: " + this.name + ".txt -> Overwriting with new numbers");
        }

        writeNumber();
    }
}
