import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Module1IO {
    public static void main(String[] args) {
        String filePath = "C:/Users/arpit/Downloads/jeans.jpeg";
        try (InputStream input = new FileInputStream(filePath)) {
            int data;
            ArrayList <Integer> filebytes =  new ArrayList<>();
            while ((data = input.read()) != -1) {
                filebytes.add(data);
            }
            FileOutputStream output = new FileOutputStream("C:/Users/arpit/Downloads/jeans_copy.jpeg");
            for (int filee : filebytes){
                output.write(filee);
            }
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
