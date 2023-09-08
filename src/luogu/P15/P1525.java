package luogu.P15;


import java.util.Arrays;
import java.util.Scanner;



/**
 * @PackageName:luogu.P15
 * @Date 2023/9/8 14:56
 * @Description:  https://www.luogu.com.cn/problem/P1525
 * # [NOIP2010 提高组] 关押罪犯
 *
 * ## 题目描述
 *
 * S 城现有两座监狱，一共关押着 $N$ 名罪犯，编号分别为 $1-N$。他们之间的关系自然也极不和谐。很多罪犯之间甚至积怨已久，如果客观条件具备则随时可能爆发冲突。我们用“怨气值”（一个正整数值）来表示某两名罪犯之间的仇恨程度，怨气值越大，则这两名罪犯之间的积怨越多。如果两名怨气值为 $c$ 的罪犯被关押在同一监狱，他们俩之间会发生摩擦，并造成影响力为 $c$ 的冲突事件。
 *
 * 每年年末，警察局会将本年内监狱中的所有冲突事件按影响力从大到小排成一个列表，然后上报到 S 城 Z 市长那里。公务繁忙的 Z 市长只会去看列表中的第一个事件的影响力，如果影响很坏，他就会考虑撤换警察局长。
 *
 * 在详细考察了$N$ 名罪犯间的矛盾关系后，警察局长觉得压力巨大。他准备将罪犯们在两座监狱内重新分配，以求产生的冲突事件影响力都较小，从而保住自己的乌纱帽。假设只要处于同一监狱内的某两个罪犯间有仇恨，那么他们一定会在每年的某个时候发生摩擦。
 *
 * 那么，应如何分配罪犯，才能使 Z 市长看到的那个冲突事件的影响力最小？这个最小值是多少？
 *
 * ## 输入格式
 *
 * 每行中两个数之间用一个空格隔开。第一行为两个正整数 $N,M$，分别表示罪犯的数目以及存在仇恨的罪犯对数。接下来的 $M$ 行每行为三个正整数 $a_j,b_j,c_j$，表示 $a_j$ 号和 $b_j$ 号罪犯之间存在仇恨，其怨气值为 $c_j$。数据保证 $1<a_j\leq b_j\leq N, 0 < c_j\leq 10^9$，且每对罪犯组合只出现一次。
 *
 * ## 输出格式
 *
 * 共 $1$ 行，为 Z 市长看到的那个冲突事件的影响力。如果本年内监狱中未发生任何冲突事件，请输出 `0`。
 *
 * ## 样例 #1
 *
 * ### 样例输入 #1
 *
 * ```
 * 4 6
 * 1 4 2534
 * 2 3 3512
 * 1 2 28351
 * 1 3 6618
 * 2 4 1805
 * 3 4 12884
 * ```
 *
 * ### 样例输出 #1
 *
 * ```
 * 3512
 * ```
 *
 * ## 提示
 *
 * 【输入输出样例说明】罪犯之间的怨气值如下面左图所示，右图所示为罪犯的分配方法，市长看到的冲突事件影响力是 $3512$（由 $2$ 号和 $3$ 号罪犯引发）。其他任何分法都不会比这个分法更优。
 *
 *  ![](https://cdn.luogu.com.cn/upload/pic/298.png)
 *
 * 【数据范围】
 *
 * 对于 $30\%$的数据有 $N\leq 15$。
 *
 * 对于 $70\%$ 的数据有 $N\leq 2000,M\leq 50000$。
 *
 * 对于 $100\%$ 的数据有 $N\leq 20000,M\leq 100000$。
 */
public class P1525 {
    private static class Node{
        public int A;
        public int B;
        public int W;

        public Node(int a, int b, int w) {
            A = a;
            B = b;
            W = w;
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N=sc.nextInt();
        int M=Integer.parseInt(sc.nextLine().trim());
        int a,b,w;
        Node[]nodes=new Node[M];
        int[]fa=new int[M*2];
        int []rank=new int[M*2];
        for (int i = 0; i <M; i++) {
            a=sc.nextInt();
            b=sc.nextInt();
            w=Integer.parseInt(sc.nextLine().trim());
            nodes[i]=new Node(a,b,w);
        }
        for (int i = 0; i < N; i++) {
            fa[i]=i;
            rank[i]=1;
        }
        Arrays.sort(nodes, (o1, o2) -> o2.W-o1.W);
        for (int i = 0; i < M; i++) {
            if(query(nodes[i].A,nodes[i].B,fa)){
                System.out.println(nodes[i].W);
                break;
            }
            merge(nodes[i].A,nodes[i].B+N,fa,rank);
            merge(nodes[i].B,nodes[i].A+N,fa,rank);
            if (i == M - 1) {
                System.out.println(0);
            }
        }
    }

    private static boolean query(int a, int b,int[]fa) {
        return find(a,fa)==find(b,fa);
    }
    private static int find(int a,int[]fa){
        return a==fa[a]?a:find(fa[a],fa);
    }
    private static void merge(int a,int b,int[]fa,int[]rank){
        int x= find(a,fa);
        int y= find(b,fa);
        if(rank[x]>=rank[y]){
            fa[y]=x;
        }else{
            fa[x]=y;
        }
        if(rank[x]==rank[y]){
            rank[x]++;
        }
    }
}
