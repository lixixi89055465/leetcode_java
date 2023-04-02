package zuo.base.class05;

import java.util.LinkedList;
import java.util.Queue;

//二叉树是否是完全二叉树
public class Code06_isBalancecdTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    private static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    private static ReturnType process(Node x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        if (!leftData.isBalanced || !rightData.isBalanced || (Math.abs(rightData.height - leftData
                .height) > 1)) {
            return new ReturnType(false, 0);
        }
        return new ReturnType(true, 1 + Math.max(rightData.height, leftData.height));
    }
}

