import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamCheck {
    public static void main(String[] args) {
        String inputPath = "B:\\JAVA\\java playground\\this is first file.txt";
        String outputPath = "B:\\JAVA\\java playground\\newFile.txt";
        
        try (FileInputStream fis = new FileInputStream(inputPath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(outputPath);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            // Loop to read and write until end of file
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush();  // Ensure all data is written
            System.out.println("File copied successfully");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

