package org.example;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    private List<Node> sortedNodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getList() {
        return this.nodes;
    }

    public Node mostImportant() {
        int importance = 0;
        int temp;
        int counter = 0;
        for (int i = 0; i < nodes.size(); i++) {
            temp = nodes.get(i).computsImportance();
            if (temp > importance) {
                importance = temp;
                counter = i;
            }
        }
        return nodes.get(counter);
    }

    public List<Node> sortNodes() {
        while (!nodes.isEmpty()) {
            Node node = mostImportant();
            this.sortedNodes.add(node);
            this.nodes.remove(node);
        }
        return sortedNodes;
    }


}
