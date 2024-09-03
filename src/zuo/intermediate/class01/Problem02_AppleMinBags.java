package zuo.intermediate.class01;

/**
 * 小虎去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个
 * 每袋的包装包装不可拆分。可是小虎现在只想购买恰好n个苹果，小虎想购买尽
 * 量少的袋数方便携带。如果不能购买恰好n个苹果，小虎将不会购买。输入一个
 * 整数n，表示小虎想购买的个苹果，返回最小使用多少袋子。如果无论如何都不
 * 能正好装下，返回-1。
 */
public class Problem02_AppleMinBags {
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = -1;
        int rest = apple % 8;
        bag8 = apple / 8;
        while (bag8 >= 0 && rest < 24) {
            int rest6 = rest % 6 == 0 ? rest / 6 : -1;
            if (rest6 != -1) {
                bag6 = rest6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1 : (apple == 12 ||
                    apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }
}
