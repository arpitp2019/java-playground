package collectionsPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class reverse {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println("Original list: " + list);
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
        System.out.println("Reversed list: " + list);
    }
}
