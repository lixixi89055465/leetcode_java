package test;

import java.util.*;

public class test09 {

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n = Integer.parseInt(scann.nextLine());
        if (n == 0) {
            System.out.println(0);
        }
        int[] statArr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            statArr[i] = i + 1;
        }
        int[][] cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = scann.nextLine();
            String[] strings = line.split(" ");
            for (int j = 0; j < n; j++) {
                cache[i][j] = Integer.parseInt(strings[j]);
            }
        }
        boolean[] visited = new boolean[n];
        ArrayList<Integer> path = new ArrayList<>();


        dfs(statArr, visited, path, minDistance, cache);
        System.out.println(minDistance);
        return;
    }

    private static void dfs(int[] statArr, boolean[] visited, ArrayList<Integer> path, int curIndex, int[][] station) {
        if (path.size() == statArr.length) {
            int pre = 0;
            int distance = 0;
            for (Integer cur : path) {
                distance += station[pre][cur];
                pre = cur;
            }
            distance += station[pre][0];
            minDistance = Math.min(distance, minDistance);
            return;
        }
        for (int i = 0; i < statArr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(statArr[i]);
            dfs(statArr, visited, path, curIndex + 1, station);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
    public static int minDistance = Integer.MAX_VALUE;
}
