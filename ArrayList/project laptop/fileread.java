import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;


public class fileread {
    public static void main(String[] args){
        Path filePath1 = Path.of("B:\\JAVA\\java playground\\this is first file.txt");
        Path filePath2 = Path.of("B:\\JAVA\\java playground\\this is second file.txt");

        try{
            String content1 = Files.readString(filePath1);
            String content2 = Files.readString(filePath2);
            System.out.println(content1 + " / now the next content is of next file / " + content2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
