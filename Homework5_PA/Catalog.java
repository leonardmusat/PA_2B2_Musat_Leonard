package org.example;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    //public void add(Document doc) {
    //    docs.add(doc);
    //}

    @java.lang.Override
    public java.lang.String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}' + "<br>";
    }

    public List getList() {
        return this.docs;
    }

    public String getName() {
        return name;
    }

}
