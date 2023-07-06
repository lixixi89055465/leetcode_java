package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;
import java.util.stream.Collectors;

public class HJ44 {
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
        int[][] sudoku = new int[9][9];
        HashSet<Integer>[] rowSet = new HashSet[9];
        HashSet<Integer>[] colSet = new HashSet[9];
        HashSet<Integer>[] subSet = new HashSet[9];
        ArrayList<Node> no = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                sudoku[i][j] = Integer.parseInt(s[j]);
                rowSet[i] = rowSet[i] == null ? new HashSet<Integer>() : rowSet[i];
                colSet[j] = colSet[j] == null ? new HashSet<Integer>() : colSet[j];
                subSet[i / 3 * 3 + j / 3] = subSet[i / 3 * 3 + j / 3] == null ? new HashSet<Integer>() : subSet[i / 3 * 3 + j / 3];
                if (sudoku[i][j] != 0) {
                    rowSet[i].add(sudoku[i][j]);
                    colSet[j].add(sudoku[i][j]);
                    subSet[i / 3 * 3 + j / 3].add(sudoku[i][j]);
                } else {
                    no.add(new Node(i, j));
                }
            }
        }
        process(sudoku, subSet, rowSet, colSet, no, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean process(int[][] sudoku, HashSet<Integer>[] subSet, HashSet<Integer>[] rowSet, HashSet<Integer>[] colSet, ArrayList<Node> no, int index) {
        if (index == no.size()) {
            return true;
        }
        HashSet<Integer> base = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Node cur = no.get(index);
        HashSet<Integer> curRowSet = rowSet[cur.row];
        HashSet<Integer> curColSet = colSet[cur.col];
        HashSet<Integer> curSubSet = subSet[cur.row / 3 * 3 + cur.col / 3];
        base.removeAll(curRowSet);
        base.removeAll(curColSet);
        base.removeAll(curSubSet);
        if (base.isEmpty()) {
            return false;
        }
        Integer[] rest = base.toArray(new Integer[base.size()]);
        for (int i1 = 0; i1 < rest.length; i1++) {
            sudoku[cur.row][cur.col] = rest[i1];
            rowSet[cur.row].add(rest[i1]);
            colSet[cur.col].add(rest[i1]);
            subSet[cur.row / 3 * 3 + cur.col / 3].add(rest[i1]);
            if (process(sudoku, subSet, rowSet, colSet, no, index + 1)) {
                return true;
            }
            sudoku[cur.row][cur.col] = 0;
            rowSet[cur.row].remove(rest[i1]);
            colSet[cur.col].remove(rest[i1]);
            subSet[cur.row / 3 * 3 + cur.col / 3].remove(rest[i1]);
        }
        return false;
    }
}
