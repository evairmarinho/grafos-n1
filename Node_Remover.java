import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

public class Node_Remover {
    private String name;

    private List<Node_Remover> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<Node_Remover, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node_Remover destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node_Remover(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<Node_Remover, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public List<Node_Remover> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node_Remover> shortestPath) {
        this.shortestPath = shortestPath;
    }
}
