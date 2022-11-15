import model.Graph;
import util.LoadData;

public class Main {

    public static void main(String[] args) {

        Graph originalGraph;
        final String data_path = "aula04/data/data.txt";

        originalGraph = LoadData.loadAdj(data_path);

        System.out.println("Matriz:");
        System.out.println(originalGraph);

        System.out.println(originalGraph.getCurrentNumVertex());
        System.out.println(originalGraph.getAllvertex());
    }
}