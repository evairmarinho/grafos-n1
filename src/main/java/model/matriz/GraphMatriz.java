package src.main.java.model.matriz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import src.main.java.model.Graph;
import src.main.java.model.Vertex;

public class GraphMatriz implements Graph {
    private double[][] mat;
    private boolean isDirected;
    private HashMap<String, Integer> names; //vertice e indice
    public Set<Vertex> all_vertex = new HashSet<>();
    private int currentNumVertex; //numero de vertices atual do grafo

    public GraphMatriz(int numVertex, boolean directed) {
        mat = new double[numVertex][numVertex];
        this.names = new HashMap<>();
        this.isDirected = directed;
        this.all_vertex = new HashSet<>();
    }

    public GraphMatriz() {}

    //adiciona uma areasta a matriz 
    public boolean addEdge(Vertex u, Vertex v, double value) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = value;
        if (!isDirected) {
            mat[column][line] = value;
        }
        return true;
    }

    //adiciona um vertice ao grafo
    @Override
    public void addVertex(Vertex v){
        // if (v.getName() == null) {
        //     throw new VertexNotFoundException("Vértice " + v.getName() + " não encontrado.");
        // }
        //names.put(v.getName(), currentNumVertex);
        all_vertex.add(v);
        //currentNumVertex++;
    }

    @Override
    public String toString() {
        String out = "";
        for (double[] linha : mat) {
            for (double valor : linha) {
                out += (valor + " ");
            }
            out += "\n";
        }
        return out;
    }

    //verifica se existe uma aresta entre dois vertices
    @Override
    public boolean adjacent(Vertex u, Vertex v) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        return mat[line][column] == 1;
    }

    @Override
    public boolean removeVertex(Vertex v) {
        // can't remove
        return false;
    }

    @Override
    public boolean removeEdge(Vertex u, Vertex v) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = 0;
        mat[column][line] = 0;
        return true;
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    public boolean notDirected() {
        return !isDirected;
    }

    public int getCurrentNumVertex() {
        return this.currentNumVertex;
    }

    public Set<Vertex> getAllvertex() {

        return this.all_vertex;
    }

}
