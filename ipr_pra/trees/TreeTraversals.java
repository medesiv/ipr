package trees;

import java.util.Stack;

public class TreeTraversals {

    public void traversePreOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(root);
        while(!stack.isEmpty()){
            curr = stack.pop();
            visit(curr.val);
            if(curr.right!=null)
                stack.push(curr.right);
            if(curr.left!=null)
                stack.push(curr.left);
        }
    }

    public void visit(int value){
        System.out.println(value);
    }

}
