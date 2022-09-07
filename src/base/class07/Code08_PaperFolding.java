package base.class07;

public class Code08_PaperFolding {
    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }

    private static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }
}
