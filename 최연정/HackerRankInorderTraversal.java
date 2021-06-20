import org.junit.jupiter.api.Test;

import java.util.Objects;

public class HackerRankInorderTraversal {
    @Test
    public void inorderTraversal(){
        inOrder(new Node(1,null, new Node(2,null, new Node(5, new Node(3, null, null), new Node(6,null, null)))));
    }

    public void inOrder(Node root){
        if(Objects.isNull(root)) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

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
