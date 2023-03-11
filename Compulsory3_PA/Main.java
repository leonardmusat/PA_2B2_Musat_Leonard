package org.example;

public class Main {
    public static void main(String[] args) {
        Node nod1 = new Company("FII");
        Node nod2 = new Person("Grigore");
        Node nod3 = new Person("Ana");
        Network link = new Network();
        link.addNode(nod1);
        link.addNode(nod2);
        link.addNode(nod3);
        System.out.println(link.getList());
    }
}