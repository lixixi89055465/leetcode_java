package base.class10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Code01_UnionFind {
    public static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values) {
            for (V value : values) {
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (parents.get(cur) != cur) {
                path.push(cur);
                cur = parents.get(cur);
            }
            while (!path.empty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                if (aSize >= bSize) {
                    parents.put(bHead, aHead);
                    sizeMap.put(aHead, aSize + bSize);
                    sizeMap.remove(bHead);
                } else {
                    parents.put(aHead, bHead);
                    sizeMap.put(bHead, aSize + bSize);
                    sizeMap.remove(aHead);

                }
            }
        }

        private class Person {
            public String str1;
            public String str2;
            public String str3;
            public Person parent;

            public Person(String str1, String str2, String str3) {
                this.str1 = str1;
                this.str2 = str2;
                this.str3 = str3;
            }
        }

        private Map<String, Integer> map1 = new HashMap<String, Integer>();
        private Map<String, Integer> map2 = new HashMap<String, Integer>();
        private Map<String, Integer> map3 = new HashMap<String, Integer>();

        public void union1(Person p1, Person p2) {
            if (p1.str1 == p2.str1 || p1.str2 == p2.str2 || p1.str3 == p2.str3) {
                return;
            }
            Person parent1 = getFindPerson(p1);
            Person parent2 = getFindPerson(p2);
            if (parent1 != parent2) {
                parent1.parent = p2;
            }
        }

        private Person getFindPerson(Person p1) {
            Person cur = p1;
            Stack<Person> pQ = new Stack<>();
            while (cur != cur.parent) {
                pQ.add(cur);
                cur = cur.parent;
            }
            while (!pQ.isEmpty()) {
                pQ.pop().parent = cur;
            }
            return cur;
        }
    }
}
