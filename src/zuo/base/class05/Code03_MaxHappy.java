package zuo.base.class05;

import java.util.List;

public class Code03_MaxHappy {
    private static class Employee {
        public int happy;
        public List<Employee> nexts;
    }

    private static class Info {
        public int laiMaxHappy;
        public int buMaxHappy;

        public Info(int happy, int buMaxHappy) {
            this.laiMaxHappy = happy;
            this.buMaxHappy = buMaxHappy;
        }
    }

    public static int maxHappy(Employee boss) {
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }

    private static Info process(Employee x) {
        if (x.nexts.size() == 0) {
            return new Info(x.happy, 0);
        }
        Info info = new Info(x.happy, 0);
        for (Employee next : x.nexts) {
            Info nextInfo = process(next);
            info.laiMaxHappy += nextInfo.buMaxHappy;
            info.buMaxHappy += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return info;
    }
}
