public class we {
    public static void main(String[] args) {

        final String name = "arpit";
        name = "new name";  // ❌ compile-time error
        System.out.println(name);
    }
}

