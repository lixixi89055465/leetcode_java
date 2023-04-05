package zuo.base.class09;

import java.util.Arrays;
import java.util.Comparator;

public class Code04_BestArrange {
    private static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange1(Program[] programs) {
        if (programs == null || programs.length == 0) {
            return 0;
        }
        return process(programs, 0, 0);
    }

    private static int process(Program[] programs, int done, int timeLine) {
        if (programs.length == 0) {
            return done;
        }
        int max = done;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeLine) {
                Program[] next = copyButExcept(programs, i);
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }
        return max;
    }

    private static Program[] copyButExcept(Program[] programs, int i) {
        return null;
    }

    public static int bestArrange2(Program[] programs) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        int timeline = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeline <= programs[i].start) {
                result++;
                timeline = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

    private static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
