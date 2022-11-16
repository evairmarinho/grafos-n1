package src.main.java;

import src.main.java.model.Graph;
import src.main.java.model.Djikstra;
import src.main.java.util.LoadData;
import src.main.java.model.matriz.GraphMatriz;
import src.main.java.model.Vertex;

public class Main {

    public static void main(String[] args) {

        GraphMatriz graph;
        Graph graphOpt;
        final String data_path = "src/main/resources/data/n1.txt";

        graph = LoadData.loadAdj(data_path);

        //System.out.println("Matriz:");
        //System.out.println(graph);
        //Djikstra algorithm = new Djikstra(); 
        Vertex[] vertex = graph.all_vertex.toArray(new Vertex[graph.all_vertex.size()]);
        graphOpt = Djikstra.calculateShortestPathFromSource(graph, vertex[3]);
        System.out.println(vertex[1].getName());
        System.out.println(graph);
        //System.out.println("======================================================");
        System.out.println(graphOpt);
    }
}