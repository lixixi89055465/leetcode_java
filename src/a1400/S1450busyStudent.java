package a1400;

import java.util.Arrays;

class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int maxEndTime = Arrays.stream(endTime).max().getAsInt();
        if (queryTime > maxEndTime) {
            return 0;
        }
        int[] cnt = new int[maxEndTime + 2];
        for (int i = 0; i < n; i++) {
            cnt[startTime[i]]++;
            cnt[endTime[i] + 1]--;
        }
        int ans = 0;
        for (int i = 0; i <= queryTime; i++) {
            ans += cnt[i];
        }
        return ans;

    }
}

public class S1450busyStudent {
    public static void main(String[] args) {
        Solution1450 solve = new Solution1450();
        int[] startTime = new int[]{9,8,7,6,5,4,3,2,1};
        int[] endTime = new int[]{10,10,10,10,10,10,10,10,10};
        int queryTime = 5;
        int result = solve.busyStudent(startTime, endTime, queryTime);
        System.out.println(result);

    }
}
