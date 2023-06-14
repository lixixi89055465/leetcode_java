package leetcode.a800;

import java.util.*;

/**
 * 886. Possible Bipartition
 * We want to split HJ93 group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 * Example 2:
 * <p>
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * All the pairs of dislikes are unique.
 * 通过次数30,673提交次数61,200
 */

public class M886_possibleBipartition {
    static class UnionFind {
        private Integer[] father;

        public UnionFind(int n) {
            father = new Integer[n + 1];
            for (int i = 0; i < n + 1; i++) {
                father[i] = i;
            }
        }

        public int findFather(int i) {
            while (father[i] != i) {
                i = father[i];
            }
            return i;
        }

        public void union(Integer f1, Integer f2) {
            f1 = findFather(f1);
            f2 = findFather(f2);
            if (f1 != f2) {
                father[f1] = f2;
            }
        }

        public boolean is_connected(int x, int y) {
            return findFather(x) == findFather(y);
        }
    }

    static class Solution {
        public static boolean possibleBipartition2(int n, int[][] dislikes) {
            UnionFind set1 = new UnionFind(n);
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int[] dislike : dislikes) {
                if (!map.containsKey(dislike[0])) {
                    map.put(dislike[0], new ArrayList<>());
                }
                if (!map.containsKey(dislike[1])) {
                    map.put(dislike[1], new ArrayList<>());
                }
                map.get(dislike[0]).add(dislike[1]);
                map.get(dislike[1]).add(dislike[0]);
            }
            for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
                Integer key = integerListEntry.getKey();
                List<Integer> value = integerListEntry.getValue();
                if (value.size() > 0) {
                    for (int i = 0; i < value.size(); i++) {
                        set1.union(value.get(0), value.get(i));
                        if (set1.is_connected(key, value.get(i))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean possibleBipartition1(int n, int[][] dislikes) {
            boolean[] isAccept = new boolean[n + 1];
            HashMap<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < dislikes.length; i++) {
                int[] dis = dislikes[i];
                if (!map.containsKey(dis[0])) {
                    Set<Integer> disSet = new HashSet<>();
                    map.put(dis[0], disSet);
                }
                if (!map.containsKey(dis[1])) {
                    Set<Integer> disSet = new HashSet<>();
                    map.put(dis[1], disSet);
                }
                map.get(dis[0]).add(dis[1]);
                map.get(dis[1]).add(dis[0]);
            }
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            Deque<Integer> deque = new LinkedList<>();
            int j = 1;
            while (!deque.isEmpty() || j <= n) {
                if (deque.isEmpty()) {
                    deque.add(j);
                    j++;
                }
                int i = deque.poll();
                isAccept[i] = true;
                if (map.containsKey(i)) {
                    Set<Integer> integers = map.get(i);
                    map.remove(i);
                    if (left.contains(i)) {
                        for (Integer integer : integers) {
                            if (left.contains(integer)) {
                                return false;
                            } else if (!right.contains(integer)) {
                                right.add(integer);
                                if (!isAccept[integer]) {
                                    deque.add(integer);
                                }
                            }
                        }
                    } else if (right.contains(i)) {
                        for (Integer integer : integers) {
                            if (right.contains(integer)) {
                                return false;
                            } else if (!left.contains(integer)) {
                                left.add(integer);
                                if (!isAccept[integer]) {
                                    deque.add(integer);
                                }
                            }
                        }
                    } else {
                        if (!left.contains(i))
                            left.add(i);
                        for (Integer integer : integers) {
                            right.add(integer);
                            deque.add(integer);
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = new int[][]{{1, 2}, {1, 3}, {2, 4}};
//        int n = 3;
//        int[][] dislikes = new int[][]{{1, 2}, {1, 3}, {2, 3}};
//        int n = 5;
//        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        Solution solution = new Solution();
        boolean result = solution.possibleBipartition2(n, dislikes);
        System.out.println(result);


    }
}
