package src.main.java;

import src.main.java.model.Graph;
import src.main.java.model.Djikstra;
import src.main.java.util.LoadData;

public class Main {

    public static void main(String[] args) {

        Graph graph;
        final String data_path = "src/main/resources/data/n1.txt";

        graph = LoadData.loadAdj(data_path);

        System.out.println("Matriz:");
        System.out.println(graph);
        Djikstra algorithm = new Djikstra(); 
        algorithm.djikstraCalcAllVertex(graph,graph.getAllvertex());
    }
}