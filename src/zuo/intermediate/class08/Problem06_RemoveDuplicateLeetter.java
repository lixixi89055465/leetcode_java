package zuo.intermediate.class08;

public class Problem06_RemoveDuplicateLeetter {
    public static String remove(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minASCIIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (--map[str.charAt(i)] == 0) {
                break;
            } else {
                minASCIIndex = str.charAt(minASCIIndex) < str.charAt(i) ? minASCIIndex : i;
            }
        }
        return str.charAt(minASCIIndex) +
                remove(
                        str.substring(minASCIIndex + 1).replaceAll(String.valueOf(str.charAt(minASCIIndex)), "")
                );
    }

    public static void main(String[] args) {

    }
}
