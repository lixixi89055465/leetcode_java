package base.class10;

import com.sun.xml.internal.xsom.XSWildcard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Code01_UnionFind<V> {
    public static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        public Map<V, Node<V>> nodes;
        public Map<Node<V>, Node<V>> parent;
        public Map<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values) {
            for (V cur : values) {
                Node<V> node = new Node<V>(cur);
                nodes.put(cur, node);
                parent.put(node, node);
                sizeMap.put(node, 1);

            }

        }

        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        private Node<V> findFather(Node<V> vNode) {
            Node<V> cur = vNode;
            Stack<Node> vStack = new Stack<Node>();
            while (parent.get(cur) != cur) {
                vStack.push(cur);
                cur = parent.get(cur);
            }
            while (vStack.isEmpty()) {
                parent.put(vStack.pop(), cur);
            }
            return cur;
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> ahead = findFather(nodes.get(a));
            Node<V> bhead = findFather(nodes.get(b));
            if (ahead != bhead) {
                int aSize = sizeMap.get(ahead);
                int bSize = sizeMap.get(bhead);
                Node<V> big = aSize >= bSize ? ahead : bhead;
                Node<V> small = aSize >= bSize ? bhead : ahead;
                parent.put(small, big);
                sizeMap.put(big, aSize + bSize);
                sizeMap.remove(small);
            }
        }

        public int getSetNum() {
            return sizeMap.size();
        }
    }

    private static class User {
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int mergeUsers(List<User> users) {
        UnionSet<User> unionFind = new UnionSet<User>(users);
        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();
        for (User user : users) {
            if (mapA.containsKey(user.a)) {
                unionFind.union(user, mapA.get(user.a));
            } else {
                mapA.put(user.a, user);
            }
            if (mapB.containsKey(user.b)) {
                unionFind.union(user, mapB.get(user.b));
            } else {
                mapB.put(user.b, user);
            }
            if (mapC.containsKey(user.c)) {
                unionFind.union(user, mapC.get(user.c));
            } else {
                mapC.put(user.c, user);
            }
        }
        return unionFind.getSetNum();
    }


    public static void main(String[] args) {
        System.out.println(null == null);
    }

}
