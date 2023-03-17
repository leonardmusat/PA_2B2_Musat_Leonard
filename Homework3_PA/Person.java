package org.example;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Person implements Comparable<Person>, Node {

    String name;
    String date;
    private Map<Node, String> relationships = new HashMap<>();
    public Person(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Person() {

    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public int computsImportance() {
        return relationships.size();
    }

}
