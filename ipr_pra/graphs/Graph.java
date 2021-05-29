package graphs;


/**
 * Time Complexity:
 *      1. To get neighbours of a vertex: O(V)
 *      2. To check if theres a direct connection between two vertices O(1)
 *
 * Space Complexity:
 *      O(V^2)
 */
class AdjacencyMatrixGraph {
    int vertices;
    int matrix[][];
    AdjacencyMatrixGraph(){

    }
    AdjacencyMatrixGraph(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination){
        matrix[source][destination]=1;

    }
    public void printGraph(){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

public class Graph{

    public static void main(String[] args){

        AdjacencyMatrixGraph amG= new AdjacencyMatrixGraph(4);
        amG.addEdge(0,1);
        amG.addEdge(2,1);
        amG.addEdge(1,2);
        amG.addEdge(1,3);
        amG.printGraph();
    }
}