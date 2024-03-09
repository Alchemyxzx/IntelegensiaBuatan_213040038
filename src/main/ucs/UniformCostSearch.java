package main.ucs;

import java.util.ArrayList;
import java.util.List;

public class UniformCostSearch {
    public void search(NodeUCS start, NodeUCS goal) {
        System.out.println("Mencari solusi dari " + start.getNilai() + " => " + goal.getNilai());

        NodeUCS eval = start;
        boolean done = false;
        List<NodeUCS> solusi = new ArrayList<>();

        while (!done) {
            System.out.println("Evaluasi: " + eval.getNilai() + " dengan cost " + eval.getCost());
            solusi.add(eval);

            if (eval.equals(goal)) {
                System.out.println("Solusi ditemukan");
                done = true;
            } else if (!eval.getNeighbors().isEmpty()) {
                NodeUCS best = null;
                double min = Integer.MAX_VALUE;

                for (NodeUCS node : eval.getNeighbors()) {
                    System.out.println(node.getNilai() + " (" + node.getCost() + "), ");

                    if (min > node.getCost()) {
                        min = node.getCost();
                        best = node;
                    }
                }
                System.out.println();
                System.out.println("Node terpilih: " + best.getNilai() + " (" + min + ")");
                eval = best;
            }
            else {
                done = true;
            }
        }

        System.out.println();
        System.out.println("Solusi ditemukan: ");
        for (NodeUCS node : solusi) {
            System.out.println(node.getNilai() + " (" + node.getCost() + ")");
        }
    }
}

