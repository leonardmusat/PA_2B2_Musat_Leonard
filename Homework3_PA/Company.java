package org.example;

import java.util.HashMap;
import java.util.Map;

public class Company implements Comparable<Company>, Node {

    private String name;
    int employeeNumber;

    private Map<Node, String> relationships = new HashMap<>();
    public Company(String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int computsImportance() {
        return relationships.size();
    }

    @Override
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public String getName() {
        return name;
    }


}
