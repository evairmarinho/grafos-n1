import model.Graph;
import util.LoadData;

public class Main {

    public static void main(String[] args) {

        Graph graph;
        final String data_path = "aula04/data/n1.txt";

        graph = LoadData.loadAdj(data_path);

        System.out.println("Matriz:");
        System.out.println(graph);

        System.out.println(graph.getCurrentNumVertex());
        System.out.println(graph.getAllvertex());
    }
}