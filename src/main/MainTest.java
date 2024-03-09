package main;

import main.dls.DepthLimitedSearch;
import main.ucs.NodeUCS;
import main.ucs.UniformCostSearch;

public class MainTest {
    public static void main(String[] args) {

        // Membuat Node dengan nama kota baru
        Node London = new Node("London");
        Node Manchester = new Node("Manchester");
        Node Birmingham = new Node("Birmingham");
        Node Liverpool = new Node("Liverpool");
        Node Bristol = new Node("Bristol");
        Node Edinburgh = new Node("Edinburgh");
        Node Glasgow = new Node("Glasgow");
        Node Leeds = new Node("Leeds");

        // Menambahkan tetangga dari setiap kota
        London.addNeighbor(Birmingham);
        London.addNeighbor(Bristol);
        London.addNeighbor(Liverpool);

        Manchester.addNeighbor(Edinburgh);
        Manchester.addNeighbor(Leeds);

        Birmingham.addNeighbor(London);
        Birmingham.addNeighbor(Glasgow);
        Birmingham.addNeighbor(Manchester);

        Liverpool.setNeighbor(London);
        Liverpool.addNeighbor(Bristol);

        Bristol.addNeighbor(London);
        Bristol.addNeighbor(Liverpool);

        Edinburgh.addNeighbor(Manchester);
        Edinburgh.addNeighbor(Glasgow);

        Glasgow.addNeighbor(Manchester);
        Glasgow.addNeighbor(Edinburgh);

        Leeds.addNeighbor(Birmingham);

        // Mencari solusi dari London ke Edinburgh menggunakan BFS, DLS, dan UCS
        System.out.println("BFS");
        main.bfs.BreadthFirstSearch bfs = new main.bfs.BreadthFirstSearch();
        bfs.search(Edinburgh, London);
        System.out.println();

        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(10);
        dls.search(London, Edinburgh);
        System.out.println();

        // Membuat NodeUCS dengan nama kota dan biaya
        NodeUCS LondonUCS = new NodeUCS(London, 0);
        NodeUCS ManchesterUCS = new NodeUCS(Manchester, 2448);
        NodeUCS BirminghamUCS = new NodeUCS(Birmingham, 2013);
        NodeUCS LiverpoolUCS = new NodeUCS(Liverpool, 1626);
        NodeUCS BristolUCS = new NodeUCS(Bristol, 1760);
        NodeUCS EdinburghUCS = new NodeUCS(Edinburgh, 0);
        NodeUCS GlasgowUCS = new NodeUCS(Glasgow, 808);
        NodeUCS LeedsUCS = new NodeUCS(Leeds, 1771);

        // Menambahkan tetangga dari setiap kota
        LondonUCS.addNeighbors(BirminghamUCS);
        LondonUCS.addNeighbors(BristolUCS);
        LondonUCS.addNeighbors(LiverpoolUCS);

        ManchesterUCS.addNeighbors(EdinburghUCS);
        ManchesterUCS.addNeighbors(LeedsUCS);

        BirminghamUCS.addNeighbors(LondonUCS);
        BirminghamUCS.addNeighbors(GlasgowUCS);
        BirminghamUCS.addNeighbors(ManchesterUCS);

        LiverpoolUCS.addNeighbors(LondonUCS);
        LiverpoolUCS.addNeighbors(BristolUCS);

        BristolUCS.addNeighbors(LondonUCS);
        BristolUCS.addNeighbors(LiverpoolUCS);

        EdinburghUCS.addNeighbors(ManchesterUCS);
        EdinburghUCS.addNeighbors(GlasgowUCS);

        GlasgowUCS.addNeighbors(ManchesterUCS);
        GlasgowUCS.addNeighbors(EdinburghUCS);

        LeedsUCS.addNeighbors(BirminghamUCS);

        // Mencari solusi dari London ke Edinburgh menggunakan UCS
        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(EdinburghUCS, LondonUCS);
    }
}
