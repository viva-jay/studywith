import org.junit.jupiter.api.Test;

import java.util.*;

public class HackerRankPostOrderTraversalStack {

    @Test
    public void postorderTraversal (){
        postOrder(new Node(1,null, new Node(2,null, new Node(5, new Node(3, null, null), new Node(6,null, null)))));
    }

    public void postOrder(Node root){
        List<Integer> list = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.data);
            if(node.left != null ){
                stack.push(node.left);
            }
            if(node.right != null ){
                stack.push(node.right);
            }
        }
        Collections.reverse(list);

        for(int data : list){
            System.out.print(data + " ");
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
