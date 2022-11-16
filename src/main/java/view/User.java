package src.main.java.view;

import src.main.java.model.Vertex;

public class User {

public void showVertexName(Vertex vertex) {

System.out.println("""
===================================================================
VÉRTICE"""+" "+vertex.getName()+"\n"+"""
===================================================================
""");
}

}
/* 
public void showVertexCost(Vertex source, Vertex target, int cost) {

    System.out.println("\n"+"Custo do vértice"+" "+source.getName()+" até o vértice "+target.getName()+" :"+cost+"\n");
    }
*/