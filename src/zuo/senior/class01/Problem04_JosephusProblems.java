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

    public static void main(String[] args) {

    }
}
