package src.main.java.model.list;

import src.main.java.model.Vertex;

public class Edge {
    private Vertex vertex;
    private double value;

    public Edge(Vertex vertex, double value) {
        this.vertex = vertex;
        this.value = value;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " [to " + vertex + ", " + value + "]";
    }

}
