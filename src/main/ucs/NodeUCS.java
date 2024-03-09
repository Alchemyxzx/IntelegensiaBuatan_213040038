package main.ucs;

import main.Node;

import java.util.ArrayList;
import java.util.List;

public class NodeUCS {
    private String nilai;
    private double cost;
    private List<NodeUCS> neighbors;

    public NodeUCS(Node node, double cost) {
        this.nilai = node.getNilai();
        this.cost = cost;
        this.neighbors = new ArrayList<>();
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getNilai() {
        return nilai;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setNeighbors(List<NodeUCS> neighbors) {
        this.neighbors = neighbors;
    }

    public List<NodeUCS> getNeighbors() {
        return neighbors;
    }

    public void addNeighbors(NodeUCS node) {
        neighbors.add(node);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodeUCS) {
            return ((NodeUCS) obj).nilai.equals(this.nilai);
        }
        return false;
    }
}

