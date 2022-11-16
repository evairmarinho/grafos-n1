package src.main.java;

import src.main.java.model.Djikstra;
import src.main.java.util.LoadData;
import src.main.java.model.matriz.GraphMatriz;
import src.main.java.model.Vertex;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        var temp = LoadData.genVertex("src/main/resources/data/n1.txt");
        String[] vertexTemp = new String[temp.length];
        for(int i=0; i<temp.length; i++)
        {
            vertexTemp[i] = temp[i];
        }

        Vertex[] vertex = new Vertex[vertexTemp.length];
        for(int i=0; i < vertexTemp.length; i++){
            vertex[i] = new Vertex(vertexTemp[i]);
        }        

        GraphMatriz graph = new GraphMatriz();

        ArrayList<String[]> edges = LoadData.Edges("src/main/resources/data/n1.txt");
        createAdjacent(vertex, edges);
        
        for(Vertex item : vertex){
            graph.addVertex(item);
        }

        graph = Djikstra.calculateShortestPathFromSource(graph, vertex[0]);

        for(Vertex item : graph.all_vertex){
            System.out.println("Vertice " + item.getName());
            var shortestPath = item.getShortestPath();
            for(var itemII : shortestPath){
                System.out.print("->" + itemII);
            }
            System.out.println("\n=======================");
        }

    }

    public static void createAdjacent(Vertex[] vertex, ArrayList<String[]> edges)
    {
        for(Vertex item : vertex){
            for(String[] edge : edges){
                if(item.getName().equals(edge[0])){
                    int i = 0;
                    while(!vertex[i].getName().equals(edge[1]))
                    {
                        i++;
                    }
                    item.addDestination(vertex[i], Integer.parseInt(edge[2]));
                }
            }
        }
    }
}