package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This is mainly if the vertices are strings instead of integers
 */
public class AdjMapListGraph {
    //vertex,neighbours
    Map<String, List<String>> adjMapList;
    String[] vertices;
    AdjMapListGraph(String[] vertices){
        this.vertices = vertices;
        this.adjMapList = new HashMap<>();
        for(String vertex: vertices){
            adjMapList.put(vertex,new LinkedList<>());
        }
    }
    void addEdge(String start,String end){
        adjMapList.get(start).add(end);
    }
}
