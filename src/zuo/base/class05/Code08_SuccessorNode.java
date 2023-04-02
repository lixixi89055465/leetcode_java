package zuo.base.class05;

public class Code08_SuccessorNode {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost(Node right) {
        if (right == null) {
            return right;
        }
        while (right.left != null) {
            right = right.left;
        }
        return right;


    }
}
