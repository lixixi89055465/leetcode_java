package zuo.base.class05;

public class Code10_PaperFolding {
    public static void printAllFold(int N) {
        printProcess(1, N, true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, down);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, !down);
    }

    public static void main(String[] args) {
        printAllFold(3);
    }
}
