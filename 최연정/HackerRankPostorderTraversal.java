import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class HackerRankPostorderTraversal {
    @Test
    public void PostorderTraversal(){
        postOrder(new Node(1,null, new Node(2,null, new Node(5, new Node(3, null, null), new Node(6,null, null)))));
    }


    public void postOrder(Node root){
        if(Objects.isNull(root)) {
            return;
        }


        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
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
