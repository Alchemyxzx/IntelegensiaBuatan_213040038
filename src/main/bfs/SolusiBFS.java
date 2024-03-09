package main.bfs;

import main.Node;

import java.util.ArrayList;
import java.util.List;

public class SolusiBFS {
    private Node node;
    private List<Node> nodes;

    public SolusiBFS() {
        nodes = new ArrayList<>();
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
