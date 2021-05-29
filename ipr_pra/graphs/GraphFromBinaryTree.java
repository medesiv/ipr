package graphs;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class GraphFromBinaryTree {

    private static void buildGraphFromTree(Map<Integer, List<TreeNode>> map, TreeNode node, TreeNode parent){
        if(node!=null){
            map.put(node.val, new ArrayList<TreeNode>());
            if(parent!=null){
                map.get(node.val).add(parent);
                map.get(parent.val).add(node);
            }
            buildGraphFromTree(map,node.left,node);
            buildGraphFromTree(map,node.right,node);
        }
    }

    private static void printGraph(Map<Integer,List<TreeNode>> res){
        for(Map.Entry<Integer, List<TreeNode>> e : res.entrySet()){
            System.out.print(e.getKey()+"->");
            for(TreeNode e1 : e.getValue())
                System.out.print(e1.val+",");
            System.out.println("");
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        Map<Integer,List<TreeNode>> result = new HashMap<>();
        buildGraphFromTree(result,root,null);
        printGraph(result);
    }
}
