package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity:
 *      1. To get neighbours of a vertex: O(1)
 *      2. To check if theres a direct connection between two vertices O(V)
 *
 * Space Complexity:
 *      O(V^2) in worst case
 *      O(V+E) - O(kV) if each vertex connects to k vertices on avg
 */
class ALGraph {
    int V;
    ArrayList<ArrayList<Integer>> adjMap;
    public ALGraph(int vertices){
        this.V = vertices;
        this.adjMap = new ArrayList<>();
        for(int i =0;i<V;i++){
            adjMap.add(new ArrayList<>());
        }
    }
    public void addEdge(int u,int v){
        adjMap.get(u).add(v);
        //For undirected we also need to add adjMap.get(v).add(u)
    }

    public void printGraph(){
        for(int i =0;i<adjMap.size();i++){
            System.out.print("Adj Map for vertex\t"+i+"->\t");
            for(int j=0;j<adjMap.get(i).size();j++){
                System.out.print(adjMap.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public boolean hasCycle(){
        boolean[] visited = new boolean[V];
        boolean[] recursiveStack = new boolean[V];

        for(int i=0;i<V;i++)
            if(detectCycle(i,visited,recursiveStack))
                return true;
        return false;
        }

    private boolean detectCycle(int v, boolean[] visited, boolean[] recursiveStack) {
        visited[v]=true;
        recursiveStack[v]=true;
        List<Integer> children = adjMap.get(v);
        for(Integer c: children)
            if(visited[c]==false) {
                if (detectCycle(c, visited, recursiveStack))
                    return true;
            }
            else if(recursiveStack[c]==true){
                return true;
            }
        recursiveStack[v]=false;
        return false;
    }}

public class AdjListGraph{
    public static void main(String[] args){
        ALGraph adjG=new ALGraph(5);
        adjG.addEdge( 0, 4);
        adjG.addEdge( 1, 2);
        adjG.addEdge( 1, 3);
        adjG.addEdge( 1, 4);
        adjG.addEdge( 2, 3);
        adjG.addEdge( 3, 4);

        adjG.printGraph();
        System.out.println("Has Cycle?:\t"+adjG.hasCycle());

        ALGraph graph = new ALGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.printGraph();
        System.out.println("Has Cycle?:\t"+graph.hasCycle());

    }


}


