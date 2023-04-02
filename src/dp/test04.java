package dp;

public class test04 {
    public static String[] sortNickName(String[] nickNameArray) {
        // write code here
        int b = 0;
        for (int i = 0; i < nickNameArray.length; i++) {
            if (!"".equals(nickNameArray[i])) {
                nickNameArray[b] = nickNameArray[i];
                b++;
            }
        }
        for (int i = b; i < nickNameArray.length; i++) {
            nickNameArray[i] = "";
        }
        return nickNameArray;
    }

    public static void main(String[] args) {
        String[] value = {"123", "", "34", "3334","","","809"};
        sortNickName(value);

    }
}
