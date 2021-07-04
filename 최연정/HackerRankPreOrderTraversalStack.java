import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Stack;

public class HackerRankPreOrderTraversalStack {
    @Test
    public void preorderTraversal (){
        preOrder(new Node(1,null, new Node(2,null, new Node(5, new Node(3, null, null), new Node(6,null, null)))));
    }

    public void preOrder(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if(!Objects.isNull(node)){
                System.out.print(node.data + " ");
                stack.push(node.right);
                stack.push(node.left);
            }
        }

    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
