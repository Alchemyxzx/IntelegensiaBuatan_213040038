package main;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String nilai;
    private List<Node> neighbors;
    private Node neighbor;

    public Node(String nilai) {
        this.nilai = nilai;
        neighbors = new ArrayList<>();
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

    public void setNeighbor(Node neighbor) {
        this.neighbor = neighbor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Node) {
            Node otherNode = (Node) obj;
            return this.nilai != null && this.nilai.equals(otherNode.nilai);
        }
        return false;
    }
}

