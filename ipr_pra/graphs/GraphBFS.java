package graphs;

import java.util.*;

/**
 * Given N = 4 number of vertices
 * Edges {(1,2),(2,1),(1,3),(3,1),(3,2),(2,3),(3,4),(4,3)}
 */

class GraphBFS{
    int N;
    Map<Integer, List<Integer>> map;
    GraphBFS(int N,int[][] edges){
        this.N = N;
        this.map = new HashMap<>();

        for(int i=1;i<=N;i++){
            map.put(i,new LinkedList<>());
        }
        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
        }
    }
    public void bfs(int s){
        boolean[] visited= new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s-1]=true;
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int neb : map.get(top)){
                if(!visited[neb-1]){
                    visited[neb-1]=true;
                    queue.offer(neb);
                }
            }
        }
    }
}

