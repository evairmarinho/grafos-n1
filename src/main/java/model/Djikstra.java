package src.main.java.model;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Djikstra {

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

    private static void CalculateMinimumDistance(Vertex evaluationVertex, Integer edgeWeigh, Vertex sourceVertex) {
        Integer sourceDistance = sourceVertex.getDistance();
        if (sourceDistance + edgeWeigh < evaluationVertex.getDistance()) {
            evaluationVertex.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Vertex> shortestPath = new LinkedList<>(sourceVertex.getShortestPath());
            shortestPath.add(sourceVertex);
            evaluationVertex.setShortestPath(shortestPath);
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
                    CalculateMinimumDistance(adjacentVertex, edgeWeight, currentVertex);
                    unsettledVertex.add(adjacentVertex);
                }
            }
            settledVertex.add(currentVertex);
        }
        return graph;
    }

}
