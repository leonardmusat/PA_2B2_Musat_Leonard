package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        System.out.println(students);

        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        System.out.println(projects);
    }
}