package zuo.base.class04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Code04_UnionFind {
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }

    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementHashMap;
        public HashMap<Element<V>, Element<V>> fathermap;
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            this.elementHashMap = new HashMap<>();
            this.fathermap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementHashMap.put(value, element);
                fathermap.put(element, element);
                this.sizeMap.put(element, 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            Element<V> aEle = this.elementHashMap.get(a);
            Element<V> bEle = this.elementHashMap.get(b);
            return findHead(a) == findHead(b);
        }

        public void union(V a, V b) {
            Element<V> aEle = this.elementHashMap.get(a);
            Element<V> bEle = this.elementHashMap.get(b);
            int aSize = 0, bSize = 0;
            while (aEle != this.fathermap.get(aEle)) {
                aEle = this.fathermap.get(aEle);
                aSize++;
            }
            Element<V> fatherEle = this.fathermap.get(bEle);
            while (bEle != fatherEle) {
                this.fathermap.put(bEle, aEle);
                bEle = fatherEle;
                fatherEle = this.fathermap.get(bEle);
            }
            this.fathermap.put(bEle, aEle);
            Element<V> vElement = this.elementHashMap.get(a);
            while (vElement != aEle) {
                fatherEle = this.fathermap.get(vElement);
                this.fathermap.put(vElement, aEle);
                vElement = fatherEle;
            }
        }

        public Element<V> findHead(V a) {
            Element<V> aEle = this.elementHashMap.get(a);
            int size = 0;
            while (aEle != this.fathermap.get(aEle)) {
                aEle = this.fathermap.get(aEle);
                size += 1;
            }
            System.out.println("size:" + size);
            return aEle;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        UnionFindSet<Integer> a = new UnionFindSet<>(list);
        a.union(1, 2);
        System.out.println(a.isSameSet(1, 2));
        a.union(1, 2);
        System.out.println(a.isSameSet(1, 2));
        a.union(1, 3);
        System.out.println(a.isSameSet(1, 3));
        a.union(1, 4);
        System.out.println(a.isSameSet(1, 4));
        a.union(3, 5);
        System.out.println(a.isSameSet(1, 5));
        a.union(5, 6);
        System.out.println(a.isSameSet(1, 6));
        a.union(7, 6);
        System.out.println(a.isSameSet(1, 7));
        a.union(8, 7);
        System.out.println(a.isSameSet(1, 8));
        a.union(8, 9);
        System.out.println(a.isSameSet(1, 9));
        a.union(8, 10);
        a.union(16, 10);
        System.out.println(a.isSameSet(1, 9));
        System.out.println("11111111");
        System.out.println();
        System.out.println(a.findHead(1).value);
        System.out.println(a.findHead(2).value);
        System.out.println(a.isSameSet(1, 3));
        System.out.println(a.isSameSet(1, 2));
        System.out.println(a.isSameSet(16, 3));


    }
}
