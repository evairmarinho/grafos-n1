package src.main.java;

import src.main.java.model.Graph;
import src.main.java.util.LoadData;

public class Main {

    public static void main(String[] args) {

        Graph graph;
        final String data_path = "src/main/resources/data/n1.txt";

        graph = LoadData.loadAdj(data_path);

        System.out.println("Matriz:");
        System.out.println(graph);

        System.out.println(graph.getCurrentNumVertex());
        System.out.println(graph.getAllvertex());
    }
}