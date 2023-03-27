package baidu;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.*;

public class Test01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numCourses    int整型
     * @param prerequisites int整型二维数组
     * @return bool布尔型
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List> map1 = new HashMap<Integer, List>();
        Map<Integer, List> map2 = new HashMap<Integer, List>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map1.containsKey(prerequisites[i][0])) {
                map1.put(prerequisites[i][0], new ArrayList());
                map1.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                map1.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            if (!map2.containsKey(prerequisites[i][0])) {
                map2.put(prerequisites[i][1], new ArrayList());
                map2.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                map2.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }
        int n = numCourses;
        List<Integer> isTrue = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            isTrue.add(i);
        }
        while (isTrue.size() <= 0) {
            int index = 0;
            for (int i = isTrue.size() - 1; i >= 0; i--) {
                if (map2.containsKey(isTrue.get(i))) {
                    List list = map2.get(isTrue.get(i));
                    int finalI = i;
                    list.forEach(e -> {
                        map1.get(e).remove(isTrue.get(finalI));
                        if (map1.get(e).size() == 0) {
                            map1.remove(e);
                        }
                    });
                    map2.remove(isTrue.get(i));
                    isTrue.remove(i);
                    index++;
                }
            }
            if (index == 0) {
                return false;
            }
        }
        return true;
    }

    protected static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();

        ListNode result=head;
        while (head!=null ){
            listNodes.add(head);
            head=head.next;
        }
        if(listNodes.size()<=1){
            return head;
        }

        for (int i = listNodes.size()-1; i > 0;i--) {
            listNodes.get(i).next=listNodes.get(i-1);
        }
        listNodes.get(0).next=null;
        return listNodes.get(listNodes.size()-1);
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
//        boolean result = test01.canFinish(2, new int[][]{{1, 0},{2,}});
//        boolean result = test01.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(2);
        ListNode l3= new ListNode(3);
        ListNode l4= new ListNode(4);
        ListNode l5= new ListNode(5);
        l1.next=l2 ;
        l2.next=l3 ;
        l3.next=l4 ;
        l4.next=l5 ;
        l5.next=null;
        ListNode listNode = test01.reverseList(l1);
        System.out.println(listNode);
    }
}
