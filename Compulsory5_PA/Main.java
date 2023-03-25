package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document doc1 = new Document("0001", "Doc1", "C:\\Users\\Lenovo\\Desktop\\DOC1");
        Document doc2 = new Document("0002", "Doc2", "C:\\Users\\Lenovo\\Desktop\\DOC2");
        Document doc3 = new Document("0003", "Doc3", "C:\\Users\\Lenovo\\Desktop\\DOC3");
        Catalog catalog = new Catalog("Catalog");
        catalog.getList().add(doc1);
        catalog.getList().add(doc2);
        catalog.getList().add(doc3);
        CatalogUtil util = new CatalogUtil();
        try {
            util.save(catalog, "lab");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(CatalogUtil.load("lab"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}