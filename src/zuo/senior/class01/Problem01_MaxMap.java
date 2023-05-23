package zuo.senior.class01;

public class Problem01_MaxMap {
    public int process(int[] arr) {
        int[] maxs = new int[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        boolean[] hasNum = new boolean[arr.length + 1];
        int maxV = arr[0], minV = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxV = Math.max(maxV, arr[i]);
            minV = Math.min(minV, arr[i]);
        }

        int bid = -1;
        for (int i = 0; i < arr.length; i++) {
            bid = arr.length * (arr[i] - minV) / (maxV - minV);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int lastMax = maxs[0];
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (hasNum[i]) {
                ans = Math.max(ans, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return ans;
    }
}
