package org.example;
import com.github.javafaker.Faker;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        var students = IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);

        List<Student> sortedStudents = Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println(sortedStudents);

        var projects = IntStream.rangeClosed(0,4)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);

        List<Project> sortedProjects = Arrays.stream(projects)
                .sorted(Comparator.comparing(Project::getName))
                .collect(Collectors.toList());

        System.out.println(sortedProjects);

        Problem prob = new Problem();
        prob.getPrefMap().put(students[0], Arrays.asList(sortedProjects.get(0), sortedProjects.get(1)));
        prob.getPrefMap().put(students[1], Arrays.asList(sortedProjects.get(0), sortedProjects.get(1), sortedProjects.get(2)));
        prob.getPrefMap().put(students[2], Arrays.asList(sortedProjects.get(2)));
        prob.getPrefMap().put(students[3], Arrays.asList(sortedProjects.get(1), sortedProjects.get(2), sortedProjects.get(3)));
        prob.getPrefMap().put(students[4], Arrays.asList(sortedProjects.get(3), sortedProjects.get(4)));

        List<Entry> entries = prob.getPrefMap().entrySet().stream()
                .filter(Problem::computeUnderAverageStudent)
                .collect(Collectors.toList());

        System.out.println("Students with a lower number of preferences than the average are:");
        for(Entry m : entries){
            System.out.println(m);
        }

        prob.solveWithGreedy();



    }
}