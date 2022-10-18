package zuo.intermediate.class01;

public class Problem07_NeedParentheses {
    public static int needParentheses(String str) {
        int count = 0;
        int needSolveRight = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    needSolveRight++;
                } else {
                    count--;
                }
            }
        }
        return count + needSolveRight;
    }

    public static void main(String[] args) {


    }
}
