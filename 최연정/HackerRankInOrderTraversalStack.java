import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class HackerRankInOrderTraversalStack {

    @Test
    public void inorderTraversal (){
        inorder(new Node(1,null, new Node(2,null, new Node(5, new Node(3, null, null), new Node(6,null, null)))));
    }

    public void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        Node current = root;

        while (current != null || ! stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.data);
            current = current.right;
        }

        for (int data : list){
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
