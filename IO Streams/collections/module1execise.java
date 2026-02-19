import java.util.*;

public class module1execise {
    public static void main(String[] args) {
        List<String> listt = new ArrayList<>(5);
        listt.add("London");
        listt.add("Paris");
        listt.add("Paris");
        listt.add("New York");
        listt.add("London");
        System.out.println("List: " + listt);
        Set<String> sett = new HashSet<>(listt);
        System.out.println("Set: " + sett);
        Map<String, Integer> student = new HashMap<>();
        student.put("Arpit", 96);
        student.put("Rahul", 85);
        student.containsKey("Keshav");
        System.out.println(student);
        Queue<String> queue = new LinkedList<>();

        // Step 1: 5 customers queue mein aate hain
        System.out.println("=== 5 Customers Queue Mein Aa Rahe Hain ===\n");
        queue.offer("Customer-1 (Token: T001)");
        queue.offer("Customer-2 (Token: T002)");
        queue.offer("Customer-3 (Token: T003)");
        queue.offer("Customer-4 (Token: T004)");
        queue.offer("Customer-5 (Token: T005)");

        System.out.println("Current Queue: " + queue);
        System.out.println("Total Customers: " + queue.size());

        // Step 2: Ek-ek karke serve karo
        System.out.println("\n=== Serving Customers One by One ===\n");

        int counter = 1;
        while (!queue.isEmpty()) {
            // Jo sabse aage hai use serve karo
            String served = queue.poll();

            System.out.println("--- Turn " + counter + " ---");
            System.out.println("✅ Serving  : " + served);
            System.out.println("📋 Remaining Queue: " + queue);
            System.out.println("👥 Remaining Count : " + queue.size());
            System.out.println();

            counter++;
        }

        System.out.println("=== Sabhi Customers Serve Ho Gaye! Queue Khali Hai ===");
    }
}