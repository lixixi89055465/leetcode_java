package zuo.intermediate.class05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Problem07_ChooseWork {
    public static class Job {
        public int money;
        public int hard;

        public Job(int money, int hard) {
            this.money = money;
            this.hard = hard;
        }
    }

    public static class JobComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        }
    }

    public static int[] getMoneys(Job[] jobs, int[] ability) {
        Arrays.sort(jobs, new JobComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Job pre = jobs[0];
        map.put(pre.hard, pre.money);
        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i].hard != pre.hard && jobs[i].money > pre.hard) {
                pre = jobs[i];
                map.put(pre.hard, pre.money);
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            Integer key = map.floorKey(ability[i]);
            ans[i] = key != null ? map.get(key) : 0;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
