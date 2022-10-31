package zuo.intermediate.class08;

public class Problem02_ExpressionNumber {

    public static int maxUnique(String str) {
        if(str==null||str.equals("")){
            return 0;
        }
        int[]map=new int[256];
        int len=0;
        int pre=-1;
        int cur=-1;
        for (int i = 0; i < str.length(); i++) {
            pre=Math.max(pre,map[str.charAt(i)]);
            cur=i-pre;
            len=Math.max(len,cur);
            map[str.charAt(i)]=i;
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
