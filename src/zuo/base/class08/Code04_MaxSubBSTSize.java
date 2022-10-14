package zuo.base.class08;


import java.util.ArrayList;
import java.util.HashMap;

public class Code04_MaxSubBSTSize {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static int maxDistance1(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = getPrelist(head);
        HashMap<Node, Node> parentMap = getParentMap(head);
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
            }
        }
        return max;
    }

    private static int distance(HashMap<Node, Node> parentMap, Node node, Node node1) {
        return 0;
    }

    private static HashMap<Node, Node> getParentMap(Node head) {
        return null;
    }

    private static ArrayList<Node> getPrelist(Node head) {
        return null;
    }

    public static class Info {
        public boolean isAllBST;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(boolean isBST, int maxSubBSTSize, int min, int max) {
            this.isAllBST = isBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public static Info process(Node head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int min = head.value;
        int max = head.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        int maxSubBSTSize = 0;
        if (leftInfo != null) {
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            maxSubBSTSize = Math.max(maxSubBSTSize, rightInfo.maxSubBSTSize);
        }
        boolean isAllBST = true;
        if (
                (leftInfo == null ? true : leftInfo.isAllBST)
                        && (rightInfo == null ? true : rightInfo.isAllBST)
                        && (leftInfo == null ? true : leftInfo.max < head.value)
                        && (rightInfo == null ? true : rightInfo.min > head.value)) {

            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    +
                    (rightInfo == null ? 0 : rightInfo.maxSubBSTSize)
                    + 1;
            isAllBST = true;
            return new Info(isAllBST, maxSubBSTSize, min, max);
        }
        return null;

    }
}
