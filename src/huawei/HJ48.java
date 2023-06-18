package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class HJ48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        for (String s1 : sc.nextLine().split(" ")) {
            arr.add(Integer.parseInt(s1));
        }
        int n = arr.get(0);
        int head = arr.get(1);
        int delNode = arr.get(arr.size() - 1);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(head, new ArrayList());
        for (int i = 2; i < arr.size() - 1; i += 2) {
            ArrayList orDefault = map.getOrDefault(arr.get(i + 1), new ArrayList());
            orDefault.add(arr.get(i));
            map.put(arr.get(i + 1), orDefault);
        }

        if (head != delNode) {
            System.out.print(head + " ");
        }
        while (map.containsKey(head)) {
            ArrayList<Integer> integers = map.get(head);
            for (int i = integers.size() - 1; i >= 0; i--) {
                if (integers.get(i) != delNode) {
                    System.out.print(integers.get(i) + " ");
                }
            }
            head = map.get(head).get(0);
        }
    }
}
