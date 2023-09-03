package leetcode.mst;

import java.util.*;

/**
 * @PackageName:leetcode.mst
 * @Date 2023/8/29 16:28
 * @Description: https://leetcode.cn/problems/sparse-similarity-lcci/
 * 面试题 17.26. 稀疏相似度
 * 提示
 * 困难
 * 43
 * 相关企业
 * 两个(具有不同单词的)文档的交集(intersection)中元素的个数除以并集(union)中元素的个数，就是这两个文档的相似度。例如，{1, 5, 3} 和 {1, 7, 2, 3} 的相似度是 0.4，其中，
 * 交集的元素有 2 个，并集的元素有 5 个。
 * 给定一系列的长篇文档，每个文档元素各不相同，并与一个 ID 相关联。它们的相似度非常“稀疏”，也就是说任选 2 个文档，相似度都很接近 0。
 * 请设计一个算法返回每对文档的 ID 及其相似度。只需输出相似度大于 0 的组合。请忽略空文档。为简单起见，可以假定每个文档由一个含有不同整数的数组表示。
 * <p>
 * 输入为一个二维数组 docs，docs[i] 表示 id 为 i 的文档。返回一个数组，其中每个元素是一个字符串，代表每对相似度大于 0 的文档，其格式为 {id1},{id2}: {similarity}，其中 id1 为两个文档中较小的 id，similarity 为相似度，精确到小数点后 4 位。以任意顺序返回数组均可。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [14, 15, 100, 9, 3],
 * [32, 1, 9, 3, 5],
 * [15, 29, 2, 6, 8, 7],
 * [7, 10]
 * ]
 * 输出:
 * [
 * "0,1: 0.2500",
 * "0,2: 0.1000",
 * "2,3: 0.1429"
 * ]
 * 提示：
 * <p>
 * docs.length <= 500
 * docs[i].length <= 500
 */
public class H1726computeSimilarities {
    private static class Solution {
        public List<String> computeSimilarities(int[][] docs) {
            Map<Integer, ArrayList<Integer>> cache = new HashMap<>();
            int n = docs.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < docs[i].length; j++) {
                    ArrayList<Integer> orDefault = cache.getOrDefault(docs[i][j], new ArrayList<>());
                    orDefault.add(i);
                    cache.put(docs[i][j], orDefault);
                }
            }
            Map<Integer, Integer> resMap = new HashMap<>();
            for (Map.Entry<Integer, ArrayList<Integer>> entry : cache.entrySet()) {
                Collections.sort(entry.getValue());
                ArrayList<Integer> value = entry.getValue();
                for (int i = 0; i < value.size(); i++) {
                    for (int j = i + 1; j < value.size(); j++) {
                        int curIndex = value.get(i) * 500 + value.get(j);
                        resMap.put(curIndex, resMap.getOrDefault(curIndex, 0) + 1);
                    }
                }
            }
            ArrayList<String> res = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : resMap.entrySet()) {
                int doc1 = entry.getKey() / 500;
                int doc2 = entry.getKey() % 500;
                double v=entry.getValue() * 10000.0/ (docs[doc1].length + docs[doc2].length-entry.getValue());
                res.add(doc1 + "," + doc2 + ": " + String.format("%.4f",Math.round(v)/10000.0));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[][] docs = {
                {14, 15, 100, 9, 3},
                {32, 1, 9, 3, 5},
                {15, 29, 2, 6, 8, 7},
                {7, 10}
        };
        List<String> res = solve.computeSimilarities(docs);
        System.out.println(res);
    }
}
