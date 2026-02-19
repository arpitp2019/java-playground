import java.io.FileInputStream;

public class DebugBuggyStream1 {
    public static void main(String[] args) {
        try {
            System.out.println("> Opening stream...");
            // Adjusted path to look into the subfolder for the file relative to root
            FileInputStream fis = new FileInputStream("IO Streams/IO debuggings/firstfile.txt");

            System.out.println("> Reading first byte...");
            int data = fis.read();
            System.out.println("  Value: " + data);

            System.out.println("> Reading second byte (skipping)...");
            fis.read();

            System.out.println("> Closing stream...");
            fis.close();

            System.out.println("> Attempting to read after close...");
            int moreData = fis.read();
            System.out.println("  Value: " + moreData);
        } catch (Exception e) {
            System.out.println("\n!!! Exception Caught !!!");
            System.out.println("Type: " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
