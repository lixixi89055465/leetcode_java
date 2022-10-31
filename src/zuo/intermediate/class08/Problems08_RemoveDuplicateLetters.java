package zuo.intermediate.class08;

public class Problems08_RemoveDuplicateLetters {
    public static String remove(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minASCIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (--map[str.charAt(i)] == 0) {
                break;
            } else {
                minASCIndex = str.charAt(minASCIndex) > str.charAt(i) ? i : minASCIndex;
            }
        }
        return String.valueOf(minASCIndex) +
                remove(
                        str
                        .substring(minASCIndex + 1)
                        .replaceAll(String.valueOf(str.charAt(minASCIndex)), ""));
    }

    public static void main(String[] args) {

    }
}
