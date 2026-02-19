package collectionsPractice;

import java.util.ArrayList;

import java.util.List;

public class Noset {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of("Delhi", "Mumbai", "Chennai"));
        List<String> list2 = new ArrayList<>(List.of("Mumbai", "Kolkata", "Delhi"));
        System.out.println(list1);
        System.out.println(list2);
        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i))) {
                continue;
            }
            list1.add(list2.get(i));
        }
        System.out.println(list1);
    }
}