package com.dacn.logicsticservice.service;

import com.dacn.logicsticservice.dto.dijkstra.Edge;
import com.dacn.logicsticservice.dto.dijkstra.Vert;

public class Dijkstra {
    public static void main(String[] args) {

        Vert vA = new Vert("A");
        Vert vB = new Vert("B");
        Vert vC = new Vert("C");
        Vert vD = new Vert("D");
        Vert vE = new Vert("E");

        vA.addNeighbour(new Edge(3, vA, vC));
        vA.addNeighbour(new Edge(5, vA, vB));
        vC.addNeighbour(new Edge(2, vC, vB));
        vC.addNeighbour(new Edge(6, vC, vE));
        vC.addNeighbour(new Edge(5, vC, vD));
        vB.addNeighbour(new Edge(4, vB, vC));
        vB.addNeighbour(new Edge(3, vB, vD));
        vB.addNeighbour(new Edge(4, vB, vE));
        vE.addNeighbour(new Edge(2, vE, vD));

        PathFinder shortestPath = new PathFinder();
        shortestPath.ShortestP(vA);
        System.out.println("Khoảng cách tối thiểu từ:");
        System.out.println("A đến B: " + vB.getDist());
        System.out.println("A đến C: " + vC.getDist());
        System.out.println("A đến D: " + vD.getDist());
        System.out.println("A đến E: " + vE.getDist());
        System.out.println("Đường đi ngắn nhất từ:");
        System.out.println("A đến B: " + shortestPath.getShortestP(vB));
        System.out.println("A đến C: " + shortestPath.getShortestP(vC));
        System.out.println("A đến D: " + shortestPath.getShortestP(vD));
        System.out.println("A đến E: " + shortestPath.getShortestP(vE));

    }
}