package com.dacn.logicsticservice.dto.dijkstra;

public class Edge {
    private long weight;
    private Vert startVert;
    private Vert targetVert;

    public Edge(long weight, Vert startVert, Vert targetVert) {
        this.weight = weight;
        this.startVert = startVert;
        this.targetVert = targetVert;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public Vert getStartVert() {
        return startVert;
    }

    public void setStartVert(Vert startVert) {
        this.startVert = startVert;
    }

    public Vert getTargetVert() {
        return targetVert;
    }

    public void setTargetVert(Vert targetVert) {
        this.targetVert = targetVert;
    }
}