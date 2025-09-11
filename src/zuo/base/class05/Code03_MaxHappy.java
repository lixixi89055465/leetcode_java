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
        if (x.nexts.isEmpty()) {
            return new Info(x.happy, 0);
        }
        int lai = x.happy;
        int bulai = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bulai += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai, bulai);
    }
}
