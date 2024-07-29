package zuo.base.class05;

import javax.print.DocFlavor;

public class Code06_IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    private static ReturnType process(Node x) {
        if (x != null) {
            return new ReturnType(true,0);
        }
        ReturnType left = process(x.left);
        ReturnType right= process(x.right);
        int height=Math.max(left.height,right.height);
        boolean isBalanced=left.isBalanced && right.isBalanced &&Math.abs(left.height-right.height)<2;
        return new ReturnType(isBalanced,height);
    }

    public static class ReturnType{
        public boolean isBalanced;
        public  int height;
        public  ReturnType(boolean isB,int hei){
            isBalanced=isB;
            height=hei;
        }
    }


}
