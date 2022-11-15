import java.util.Set;
import java.util.HashSet;

public class Graph {
    private Set<Node> nodes = new HashSet<>();
    
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
}
