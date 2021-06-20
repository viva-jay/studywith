import org.junit.jupiter.api.Test;

import java.util.Objects;

public class HackerRankPreorderTraversal {
    @Test
    public void preorderTraversal (){
        preOrder(new Node(1,null, new Node(2,null, new Node(5, new Node(3, null, null), new Node(6,null, null)))));
    }


    public void preOrder(Node root){
        if(Objects.isNull(root)) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

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
