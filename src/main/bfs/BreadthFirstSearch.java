package main.bfs;

import main.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
    public void search(Node start, Node goal) {
        Queue<SolusiBFS> queue = new LinkedList<>();
        Set<Node> visitedNodes = new HashSet<>();

        SolusiBFS solusiStart = new SolusiBFS();
        solusiStart.setNode(start);
        queue.add(solusiStart);
        System.out.println("Mencari solusi dari " + start.getNilai() + " => " + goal.getNilai());

        int step = 0;
        while (!queue.isEmpty() && step < 100) {  // Batas maksimum langkah
            SolusiBFS eval = queue.poll();
            Node currentNode = eval.getNode();
            System.out.println("Langkah: " + step + ", Evaluasi: " + currentNode.getNilai());

            if (currentNode.equals(goal)) {
                System.out.println("Solusi ditemukan");
                break;
            }
            else {
                visitedNodes.add(currentNode);
                for (Node successor : currentNode.getNeighbors()) {
                    if (!visitedNodes.contains(successor)) {
                        SolusiBFS solusiSuccessor = new SolusiBFS();
                        solusiSuccessor.setNode(successor);
                        solusiSuccessor.setNodes(eval.getNodes());
                        solusiSuccessor.getNodes().add(currentNode);

                        queue.offer(solusiSuccessor);
                    }
                }
            }
            step++;
        }

        if (step >= 100) {
            System.out.println("Pencarian melewati batas maksimum langkah.");
        }
    }
}
