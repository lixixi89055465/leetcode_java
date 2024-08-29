package zuo.intermediate.class08;

import java.util.Map;

public class Problem02 {
    public static boolean isValid(char[] exp) {
        if ((exp.length & 1) == 0) {
            return false;
        }
        for (int i = 0; i < exp.length; i++) {
            if ((exp[i] != '1') && (exp[i] != '0')) {
                return false;
            }
        }
        for (int i = 1; i < exp.length; i++) {
            if ((exp[i] != '&') && (exp[i] != '|') && (exp[i] != '^')) {
                return false;
            }
        }
        return true;
    }

    public static int num1(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return p(exp, desired, 0, exp.length - 1);
    }

    private static int p(char[] exp, boolean desired, int L, int R) {
        if (L == R) {
            if (exp[L] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        // L..R
        int res = 0;
        if (desired) {
            for (int i = L + 1; i <= R; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, true, L, i - 1) *
                                p(exp, true, i + 1, R);
                    case '|':
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                    case '^':
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                        break;

                }

            }
        } else {
            for (int i = L + 1; i <= R; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                    case '|':
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                    case '^':
                        res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
                        res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
                        break;
                }

            }
        }

        return 0;
    }

    public static int num2(String express, boolean desired) {
        char[] chs = express.toCharArray();
        int[][] fDp = new int[chs.length][chs.length];//false
        int[][] tDp = new int[chs.length][chs.length];//true
        for (int i = 0; i < chs.length; i += 2) {
            for (int j = 0; j < i; j += 2) {
                if (i == j) {
                    fDp[i][j] = chs[i] == '0' ? 1 : 0;
                    tDp[i][j] = chs[i] == '1' ? 1 : 0;
                } else {
                    for (int k = i; k < j; k += 2) {
                        if (chs[k + 1] == '&') {
                            fDp[i][j] += fDp[i][k] * tDp[k + 2][j];
                            fDp[i][j] += tDp[i][k] * fDp[k + 2][j];
                            fDp[i][j] += fDp[i][k] * fDp[k + 2][j];
                            tDp[i][j] += tDp[i][k] * tDp[k + 2][j];
                        } else if (chs[k + 1] == '|') {
                            tDp[i][j] += fDp[i][k] * tDp[k + 2][j];
                            tDp[i][j] += tDp[i][k] * fDp[k + 2][j];
                            tDp[i][j] += tDp[i][k] * tDp[k + 2][j];
                            fDp[i][j] += fDp[i][k] * fDp[k + 2][j];
                        } else if (chs[k + 1] == '^') {
                            tDp[i][j] += fDp[i][k] * tDp[k + 2][j];
                            tDp[i][j] += tDp[i][k] * fDp[k + 2][j];
                            fDp[i][j] += fDp[i][k] * tDp[k + 2][j];
                            fDp[i][j] += tDp[i][k] * fDp[k + 2][j];
                        }
                    }
                }
            }

        }
        return desired ? tDp[0][tDp.length - 1] : fDp[0][fDp.length - 1];
    }

    public static void main(String[] args) {
        String express = "1^0&0|1&1^0&0^1|0|1&1";
        boolean desired = true;
        System.out.println(num1(express, desired));
        System.out.println(num2(express, desired));
    }
}
