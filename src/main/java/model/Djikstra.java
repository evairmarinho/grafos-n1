package src.main.java.model;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import src.main.java.view.User;

public class Djikstra {

    User interface_graph = new User();

    private static Vertex getLowestDistanceVertex(Set<Vertex> unsettledVertex) {
        Vertex lowestDistanceVertex = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Vertex vertex : unsettledVertex) {
            int vertexDistance = vertex.getDistance();
            if (vertexDistance < lowestDistance) {
                lowestDistance = vertexDistance;
                lowestDistanceVertex = vertex;
            }
        }
        return lowestDistanceVertex;
    }

    private static void CalculateMinimumDistance(Vertex source,Vertex target, Integer edgeWeigh) {
        Integer sourceDistance = source.getDistance();
        if (sourceDistance + edgeWeigh < target.getDistance()) {
            target.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Vertex> shortestPath = new LinkedList<>(source.getShortestPath());
            shortestPath.add(source);
            target.setShortestPath(shortestPath);
        }
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Vertex source) {
        source.setDistance(0);

        Set<Vertex> settledVertex = new HashSet<>();
        Set<Vertex> unsettledVertex = new HashSet<>();

        unsettledVertex.add(source);

        while (unsettledVertex.size() != 0) {
            Vertex currentVertex = getLowestDistanceVertex(unsettledVertex);
            unsettledVertex.remove(currentVertex);
            for (Entry<Vertex, Integer> adjacencyPair : currentVertex.getAdjacentVertex().entrySet()) {
                Vertex adjacentVertex = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledVertex.contains(adjacentVertex)) {
                    CalculateMinimumDistance(currentVertex,adjacentVertex, edgeWeight);
                    unsettledVertex.add(adjacentVertex);
                }
            }
            settledVertex.add(currentVertex);
        }
        return graph;
    }

    /*public void djikstraCalcAllVertex(Graph graph, Set<Vertex> vertex_list) {
        Iterator<Vertex> djikstraCalc = vertex_list.iterator();

        while (djikstraCalc.hasNext()) {
            interface_graph.showVertexName(djikstraCalc.next());
            System.out.println(calculateShortestPathFromSource(graph, djikstraCalc.next()));
        }
    }*/
}
