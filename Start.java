/**
 * The Start class is the entry point for the "Parallel Max Finder" OS project.
 * It demonstrates multithreading by:
 * - Generating 4 files with 1,000,000 random integers each using writer threads
 * - Reading each file in parallel using separate threads to find the maximum
 * number
 * - Determining and printing the overall maximum value across all files
 */
public class Start {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========== OS Project: Parallel Max Finder ==========");
        System.out.println("Generating files with 1,000,000 random integers each...");
        System.out.println("-----------------------------------------------------");

        FileNumWriter f1 = new FileNumWriter("file1");
        FileNumWriter f2 = new FileNumWriter("file1");
        FileNumWriter f3 = new FileNumWriter("file3");
        FileNumWriter f4 = new FileNumWriter("file4");

        f1.start();
        f2.start();
        f3.start();
        f4.start();

        f1.join();
        f2.join();
        f3.join();
        f4.join();

        System.out.println("All files generated!\n");

        System.out.println("========== STEP 2: Finding Maximums in Files ==========");
        System.out.println("Starting max-finding threads for each file...\n");

        TMax max1 = new TMax(f1.getFile());
        TMax max2 = new TMax(f2.getFile());
        TMax max3 = new TMax(f3.getFile());
        TMax max4 = new TMax(f4.getFile());

        max1.start();
        max2.start();
        max3.start();
        max4.start();

        max1.join();
        max2.join();
        max3.join();
        max4.join();

        int num1 = max1.getMax();
        int num2 = max2.getMax();
        int num3 = max3.getMax();
        int num4 = max4.getMax();

        System.out.println("Max in " + max1.getFileName() + " = " + num1);
        System.out.println("Max in " + max2.getFileName() + " = " + num2);
        System.out.println("Max in " + max3.getFileName() + " = " + num3);
        System.out.println("Max in " + max4.getFileName() + " = " + num4);

        int max = num1;
        String fileName = max1.getFileName();

        if (num2 > max) {
            max = num2;
            fileName = max2.getFileName();
        }
        if (num3 > max) {
            max = num3;
            fileName = max3.getFileName();
        }
        if (num4 > max) {
            max = num4;
            fileName = max4.getFileName();
        }

        System.out.println("\n====================  FINAL RESULT  ====================");
        System.out.println("Maximum value is " + max + " found in file: " + fileName);
    }
}
