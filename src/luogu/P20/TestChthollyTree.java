package luogu.P20;

import java.util.*;

/**
 * @PackageName:luogu.P20
 * @Date 2023/9/18 10:05
 * @Description:
 */
public class TestChthollyTree {
    private static class Node{
        public Integer left;
        public Integer right;
        public Integer value;

        public Node(Integer left, Integer right, Integer value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    private static class ChthollyTree{
        public TreeSet<Node> tree= new TreeSet<>(Comparator.comparingInt(o -> o.left));
        public Node split(int pos){
            Node LNode = tree.lower(new Node(pos+1,0,0));
            if (LNode.left == pos) {
                return LNode;
            }
            tree.remove(LNode);
            tree.add(new Node(LNode.left,pos-1,LNode.value));
            Node RNode=new Node(pos,LNode.right,LNode.value);
            tree.add(RNode);
            return RNode;
        }
        public void add(int left,int right,int value){
            Node LNode = this.split(left);
            Node RNode=this.split(right+1);
            tree.subSet(LNode,RNode).forEach(e-> e.value+=value);
        }
        public int kth(int left,int right,int k){
            Node end=this.split(right+1);
            SortedSet<Node> nodes = tree.subSet(this.split(left), end);
            Node[] nodes1 = new Node[nodes.size()];
            nodes.toArray(nodes1);
            Arrays.sort(nodes1, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.value-o2.value;
                }
            });
            for (Node node : nodes1) {
                int tmp=node.right-left+1;
                if(tmp<=k){
                    return node.value;
                }
                k-=tmp;
            }
            return -1;
        }
        public int sumOfPow(int left,int right,int y){
            Node end=this.split(right+1);
            int sum= tree.subSet(this.split(left), end).stream().mapToInt(e -> (int) Math.pow(e.value, y)).sum();
            return sum;
        }
        public void assign(int left,int right,int value){
            tree.subSet(this.split(left), this.split(right)).stream().forEach(e->{
                e.value=value;
            });
        }
    }
    public static void main(String[] args) {

    }
}
