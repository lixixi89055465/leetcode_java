package zuo.intermediate.class04;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Comparator;
import java.util.PriorityQueue;

import static zuo.base.class08.Code04_MaxSubBSTSize.process;

public class Coffee01 {
    private static class Machine {
        public int timePoint;
        public int workTime;

        public Machine(int timePoint, int workTime) {
            this.timePoint = timePoint;
            this.workTime = workTime;
        }
    }

    private static class MachineComparator implements Comparator<Machine> {

        @Override
        public int compare(Machine o1, Machine o2) {
            return o1.timePoint + o1.workTime - o2.timePoint - o2.workTime;
        }
    }

    public static int minTime2(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<>(new MachineComparator());
        for (int i = 0; i < arr.length; i++) {
            heap.add(new Machine(0, arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine cur = heap.poll();
            cur.timePoint += cur.workTime;
            drinks[i] = cur.timePoint;
            heap.add(cur);
        }
        return process(drinks, a, b, 0, 0);

    }

    public static void main(String[] args) {

    }
}
