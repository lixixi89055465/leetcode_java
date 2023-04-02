package baidu;

import java.util.*;

public class Test03 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numCourses    int整型
     * @param prerequisites int整型二维数组
     * @return bool布尔型
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        Map<Integer,List<Integer>> map2=new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map2.containsKey(prerequisites[i][1])) {
                map2.put(prerequisites[i][1], new ArrayList());
                map2.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                map2.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }
        Set<Integer>isTrue=new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            isTrue=new HashSet<>();
            isTrue.add(i);
            boolean result=dfs(i,map2,isTrue);
            if(result==false){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> prerequisites, Set<Integer> isTrue) {
        List list = prerequisites.get(i);
        if(list==null){
            return true;
        }
        for (int i1 = 0; i1 < list.size(); i1++) {
            boolean result = true;
            if (isTrue.contains(list.get(i1 ))) {
                return false;
            } else {
                isTrue.add((Integer) list.get(i1));
                result = dfs((Integer) list.get(i1), prerequisites, isTrue);
            }
            if (!result) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Test03 test01 = new Test03();
        boolean result = test01.canFinish(2, new int[][]{{1, 0}});
//        boolean result = test01.canFinish(2, new int[][]{{1, 0},{0,1}});
        System.out.println(result);
    }
}
