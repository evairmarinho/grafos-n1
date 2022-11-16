package src.main.java.model;

import src.main.java.exception.VertexNotFoundException;

import java.util.Set;

public interface Graph {
    boolean adjacent(Vertex u, Vertex v);

    void addVertex(Vertex v) throws VertexNotFoundException;

    boolean removeVertex(Vertex v);

    boolean addEdge(Vertex u, Vertex v, double value);

    boolean removeEdge(Vertex u, Vertex v);

    boolean isDirected();

    int getCurrentNumVertex();

    Set<Vertex> getAllvertex();
}
