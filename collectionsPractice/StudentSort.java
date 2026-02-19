package collectionsPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class StudentSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Arpit", 99));
        students.add(new Student("Rahul", 89));
        students.add(new Student("Sagar", 20));
        students.add(new Student("Mohit", 69));
        students.add(new Student("Ankit", 32));
        System.out.println("List before sort: " + students);

        // Sort by marks (descending)
        Collections.sort(students, (s1, s2) -> s2.getMarks() - s1.getMarks());
        System.out.println("List after sort: " + students);

        students.removeIf(s -> s.getMarks() < 40);
        System.out.println("List after removing failed students: " + students);
    }
}

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public int getMarks() {
        return this.marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}


