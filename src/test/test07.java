package test;

import java.util.*;

public class test07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String infos = in.nextLine();
        String[] s = infos.split(" ");
        TreeMap<Integer, Integer> infoMap = new TreeMap<>();
        for (int i = 0; i < s.length; i+=2) {
            infoMap.put(Integer.parseInt(s[i]),Integer.parseInt(s[i+1]));
        }
        String s1 = in.nextLine();
        String[] s2 = s1.split(" ");

        TreeMap<Integer, Integer> xiaoFeiInMap = new TreeMap<>();
        TreeMap<Integer, Integer> xiaoFeiOutMap = new TreeMap<>();
        LinkedList<Integer> curQueue = new LinkedList<>();
        TreeMap<Integer,ArrayList<Integer>>result=new TreeMap<>();
        int index=0;
        for (int i = 0; i < s2.length; i+=2) {
            xiaoFeiInMap.put(Integer.parseInt(s2[i]),index);
            xiaoFeiOutMap.put(Integer.parseInt(s2[i+1]),index);
            result.put(index,new ArrayList<>());
            index++;
        }
        for (Map.Entry<Integer, Integer> entry : infoMap.entrySet()) {
            while (!xiaoFeiOutMap.isEmpty()&&entry.getKey() >= xiaoFeiOutMap.firstKey()) {
                curQueue.remove(xiaoFeiOutMap.pollFirstEntry().getValue());
            }
            while (!xiaoFeiInMap.isEmpty()&&entry.getKey() >= xiaoFeiInMap.firstKey()) {
                curQueue.add(xiaoFeiInMap.pollFirstEntry().getValue());
            }
            if(!curQueue.isEmpty()) {
                Integer cur = curQueue.peekLast();
                result.get(cur).add(entry.getValue());
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry: result.entrySet()) {
            if (entry.getValue().isEmpty()) {
                System.out.print("-1");
            }else{
                entry.getValue().forEach(e->{
                    System.out.print(e+" ");
                });
            }
            System.out.println();
        }
    }

}
