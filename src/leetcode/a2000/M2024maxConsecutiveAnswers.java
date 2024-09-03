package leetcode.a2000;

/**
 * 2024. 考试的最大困扰度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * <p>
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * <p>
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：answerKey = "TTFF", k = 2
 * 输出：4
 * 解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
 * 总共有四个连续的 'T' 。
 * 示例 2：
 * <p>
 * 输入：answerKey = "TFFT", k = 1
 * 输出：3
 * 解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
 * 或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
 * 两种情况下，都有三个连续的 'F' 。
 * 示例 3：
 * <p>
 * 输入：answerKey = "TTFTTFTT", k = 1
 * 输出：5
 * 解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
 * 或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
 * 两种情况下，都有五个连续的 'T' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == answerKey.length
 * 1 <= n <= 5 * 104
 * answerKey[i] 要么是 'T' ，要么是 'F'
 * 1 <= k <= n
 */
public class M2024maxConsecutiveAnswers {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chs = answerKey.toCharArray();
        return Math.max(
                maxConsecutiveAnswers(chs, k, 'T'),
                maxConsecutiveAnswers(chs, k, 'F'));
    }

    private static int maxConsecutiveAnswers(char[] chs, int k, char C) {
        int left = 0, right = 0;
        int curK = 0;
        int res = 0;
        while (left <= right && right < chs.length) {
            if (chs[right] == C) {
                curK++;
            }
            if (curK <= k) {
                right++;
                continue;
            }
            res = Math.max(res, right - left);
            while (curK > k) {
                if (chs[left] == C) {
                    curK--;
                }
                left++;
            }
            right++;
        }
        res = Math.max(right - left, res);
        return res;
    }

    public static void main(String[] args) {
//        String answerKey = "TTFTTFTT";
//        int k = 1;
//        String answerKey = "TTFF";
//        int k = 2;
//        String answerKey = "TTFTTFTT";
//        int k = 1;
        String answerKey = "FFFTTFTTFT";
        int k = 3;
        int res = maxConsecutiveAnswers(answerKey, k);
        System.out.println(res);
    }
}
