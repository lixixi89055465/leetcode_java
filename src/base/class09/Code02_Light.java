package base.class09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Code02_Light {
    public static int process(char[] str, int index, HashSet<Integer> lights) {
        if (index == str.length) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'X') {
                    if (!lights.contains(str[i - 1]) && !lights.contains(str[i]) && !lights.contains(str[i + 1])) {
                        return Integer.MAX_VALUE;
                    }
                }

            }
            return lights.size();
        } else {
            int no = process(str, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (str[index] == '.') {
                lights.add(index);
                yes = process(str, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    public static int minLight2(String road) {
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else {
                light++;
                if (str[index + 1] == 'X') {
                    index += 2;
                } else {
                    index += 3;
                }
            }
        }
        return light;
    }

    public static void main(String[] args) {

        int result=Code02_Light.minLight2("X.XXX.....XX");
        System.out.println(result);
    }

}
