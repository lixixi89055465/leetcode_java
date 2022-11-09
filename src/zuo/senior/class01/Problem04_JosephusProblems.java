package zuo.senior.class01;

public class Problem04_JosephusProblems {
    protected static class Node {
        public Node next;
        public int value;
    }
    public static Node josephusKill2(Node head,int m){
        if(head==null||head.next==head||m<1){
            return head;
        }
        Node cur=head.next;
        int tmp=1;
        while (cur!=head){
            tmp++;
            cur=cur.next;
        }
        tmp=getLive(tmp,m);
        while (--tmp!=0){
            head=head.next;
        }
        head.next=head;
        return head;
    }
    public static int getLive(int i,int m){
        if(i==1){
            return -1;
        }
        return (getLive(i-1,m)+m-1)%i+1;
    }
    public static void printCircularList(Node head){
        if(head==null){
            return;
        }
        System.out.println("Circular list :"+head.value+" ");
        Node cur = head.next;
        while (cur!=head){
            System.out.println(cur.value+"\t");
            cur=cur.next;
        }
        System.out.println("->\t"+head.value);
    }
    public static int getNo(int x,int i,int m){
        return (x+m-1)%i+1;
    }
    //0....n-1个人围成一圈，依次循环取用 arr中的数字 。
    //杀n-1轮，返回活的人的原始编号
    public static int live(int n,int []arr){
        return 0;
    }
    public static int no(int i,int []arr,int index){
        if(i==1){
            return 1;
        }
        // 老=(新 + m -1 ) %i +1
        return (no(i-1,arr,nextIndex(arr.length,index))
                        +arr[index]-1)%i+1;

    }
    //如果数组长度为 size，当前下标为index,返回循环的模型下，下一个index是多少
    public static int nextIndex(int size,int index){
        return index==size-1?0:index+1;

    }

    public static void main(String[] args) {

    }
}
