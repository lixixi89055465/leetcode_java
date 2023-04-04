package zuo.base.class07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_BestArrange {
    private static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int BestArrange(Program[] programe, int timePoint) {
        PriorityQueue<Program> queue = new PriorityQueue<>(new ProgramComparator01());
        for (Program program : programe) {
            queue.add(program);
        }
        int lastEnd = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Program cur = queue.poll();
            if (cur.start >= lastEnd) {
                result++;
                lastEnd = cur.end;
            }
        }
        return result;
    }

    private class ProgramComparator01 implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.end - o1.end;
        }
    }
}
