public class BuggyStream1 {
    public static void main(String[] args) {
        FileInputStream fis = new FileInputStream("test.txt");
        int data = fis.read();
        System.out.println(data);
        fis.read();
        fis.close();
        int moreData = fis.read();
        System.out.println(moreData);
    }
}