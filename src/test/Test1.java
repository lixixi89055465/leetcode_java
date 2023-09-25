package test;

import java.util.Scanner;

public class Test1 {
    private static class Tree{
        public  int[]tree;
        public Tree(int n) {
            tree=new int[n];
        }
        public   void update(int i, int x){
            int maxLen=this.tree.length;
            for(;i<=maxLen;i+=lowBit(i)){
                tree[i]+=x;
            }
        }
        public  int query(int n){
            int ans=0;
            for (int i = n; i > 0; i-=lowBit(i)) {
                ans+=tree[i];
            }
            return ans;
        }
        private   int lowBit(int i) {
            return i&-i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int []ans=new int[n];
        Tree tree = new Tree(n);
        for (int i = 0; i < n; i++) {
            int curV = sc.nextInt();

        }
    }
}
