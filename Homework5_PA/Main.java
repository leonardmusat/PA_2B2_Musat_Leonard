package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Document doc1 = new Document("0001", "Doc1", "null");
        Document doc2 = new Document("0002", "Doc2", "DOC2.txt");
        Document doc3 = new Document("0003", "Doc3", "C:\\Users\\Lenovo\\Desktop\\DOC3");
        Catalog catalog = new Catalog("Catalog");
        Catalog emptyCatalog = new Catalog ("emptyCatalog");
        AddCommand add = new AddCommand();
        try {
            add.add(doc1, catalog.getList());
        } catch (ExceptionNoPath e){
            throw new RuntimeException(e);
        }
        try {
            add.add(doc2, catalog.getList());
        } catch (ExceptionNoPath e){
            throw new RuntimeException(e);
        }
        try {
            add.add(doc3, catalog.getList());
        } catch (ExceptionNoPath e){
            throw new RuntimeException(e);
        }
        ListCommand print = new ListCommand();
        try {
            print.list(catalog);
        } catch (ExceptionNullList er) {
            throw new RuntimeException(er);
        }

        try {
          print.list(emptyCatalog);
        } catch (ExceptionNullList e) {
            System.err.println("Error list empty");
        } finally {
            System.out.println("Smth went wrong, lsit " + emptyCatalog.getList() + " from " + emptyCatalog.getName() + " is empty");
        }
        //CatalogUtil util = new CatalogUtil();
        try {
            CatalogUtil.save(catalog, "lab");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(CatalogUtil.load("lab"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DesktopCommand desktop = new DesktopCommand();
        doc2.addTag("ADD", add);
        doc2.addTag("LIST", print);
        doc3.addTag("DESKTOP", desktop);

        try {
            CatalogUtil.saveDoc(doc2, doc2.getLocation());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File(doc2.getLocation());
        try {
            desktop.desktop(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}