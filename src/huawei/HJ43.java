package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class HJ43 {
    private static class Node {
        public int row;
        public int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 0, col = 0;
        String[] s = sc.nextLine().split(" ");
        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);
        boolean[][] valid = new boolean[row][col];
        int[][] labyrinth = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] s1 = sc.nextLine().split(" ");
            for (int i1 = 0; i1 < col; i1++) {
                labyrinth[i][i1] = Integer.parseInt(s1[i1]);
            }
        }
        LinkedList<Node> stack = new LinkedList<>();
        process(labyrinth, valid, 0, 0, stack);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println("(" + cur.row + "," + cur.col + ")");
        }
    }

    private static boolean process(int[][] labyrinth, boolean[][] valid, int row, int col, LinkedList<Node> stack) {
        int n = labyrinth.length;
        int m = labyrinth[0].length;
        stack.add(new Node(row, col));
        if (row == n - 1 && col == m - 1) {
            valid[row][col] = true;
            return true;
        }
        if (row > n - 1 || row < 0 || col > m - 1 || col < 0
                || labyrinth[row][col] == 1 || valid[row][col]) {
            stack.pollLast();
            return false;
        }
        valid[row][col] = true;

        if (process(labyrinth, valid, row + 1, col, stack) ||
                process(labyrinth, valid, row - 1, col, stack) ||
                process(labyrinth, valid, row, col + 1, stack) ||
                process(labyrinth, valid, row, col - 1, stack)) {
            return true;
        }
        valid[row][col] = false;
        stack.pollLast();
        return false;
    }
}
