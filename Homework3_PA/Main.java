package org.example;

public class Main {
    public static void main(String[] args) {
        Node rica = new Programmer("Rica","24/07/2000");
        Node monica = new Programmer("Monica", "30/07/2000");
        Node ioana = new Designer ("Ioana", "10/01/1990");
        Node iancu = new Designer ("Iancu", "01.01.2001");
        Node raul = new Designer ("Raul", "05.04.1980");
        Node bit = new Company("Bit-defender", 10);
        Node conti = new Company("Continental", 15);
        Network net = new Network();
        rica.addRelationship(monica, "prieteni");
        rica.addRelationship(ioana, "matusa");
        rica.addRelationship(iancu, "prieten");
        rica.addRelationship(raul, "tata");
        rica.addRelationship(bit, "angajat");
        monica.addRelationship(rica, "prieteni");
        monica.addRelationship(ioana, "prieteni");
        raul.addRelationship(rica, "fiu");
        raul.addRelationship(iancu, "prieteni");
        raul.addRelationship(conti, "angajat");
        iancu.addRelationship(conti, "angajat");
        conti.addRelationship(iancu, "amgajator");
        conti.addRelationship(raul, "angajator");
        bit.addRelationship(rica, "angajator");
        net.addNode(monica);
        net.addNode(ioana);
        net.addNode(rica);
        net.addNode(iancu);
        net.addNode(raul);
        net.addNode(bit);
        net.addNode(conti);
        System.out.println("The importance of node rica is: " + rica.computsImportance());
        System.out.println("The importance of node conti is: " + conti.computsImportance());
        System.out.println("Nodes sorted by their importance are:" + net.sortNodes());

    }
}