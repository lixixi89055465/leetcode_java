package zuo.intermediate.class01;

public class Problem02_AppleMinBags {
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = -1;
        int rest = apple % bag8;
        bag8 = apple / bag8;
        while (bag8 >= 0 && rest < 24) {
            int rest6 = rest % 6 == 0 ? rest / 6 : -1;
            if (rest != -1) {
                bag6 = rest6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }
}

