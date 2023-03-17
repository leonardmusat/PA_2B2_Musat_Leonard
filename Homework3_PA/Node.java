package org.example;

public interface Node {
    String getName();
    void setName(String name);
    public int computsImportance();
    public void addRelationship(Node node, String value);
}
