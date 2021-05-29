package graphs;

import java.util.HashMap;
import java.util.Map;

public class AdjMapMapGraph {
    String[] vertices;
    Map<String, Map<String,Double>> adjMap;
    AdjMapMapGraph(String[] vertices){
        this.vertices = vertices;
        this.adjMap = new HashMap<>();
        for(String vertex: vertices){
            adjMap.put(vertex,new HashMap<>());
        }
    }

    void addEdge(String start, String end, double weight){
        adjMap.get(start).put(end,weight);
    }
}
