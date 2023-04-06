package zuo.base.class08;

public class Code07_knpack {
    public static int process1(int[] weights, int[] value, int i,
                               int alreadyweight, int bag) {
        if (alreadyweight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return 0;
        }
        return Math.max(
                process1(weights, value, i + 1, alreadyweight, bag),
                value[i] + process1(weights, value, i + 1, alreadyweight + weights[i], bag)
        );
    }

    public static int process2(int[] weights, int[] values,
                               int i, int alreadyWeight, int alreadyValue, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == values.length) {
            return alreadyValue;
        }
        return Math.max(
                process2(weights, values, i + 1, alreadyWeight, alreadyValue, bag),
                process2(weights, values, i + 1, alreadyWeight + weights[i], alreadyValue + values[i], bag)
        );
    }
}
