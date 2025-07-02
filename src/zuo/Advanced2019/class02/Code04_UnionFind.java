package zuo.Advanced2019.class02;


import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class
Code04_UnionFind {
    //    public static class Element<V> {
//        public V value;
//
//        public Element(V value) {
//            this.value = value;
//        }
//    }
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        //key 某个元素 value 该元素的父
        public HashMap<Element<V>, Element<V>> fatherMap;
        //key 某
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V v : list) {
                Element<V> element = new Element<>(v);
                elementMap.put(v, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            Element<V> ea = findHead(elementMap.get(a));
            Element<V> eb = findHead(elementMap.get(b));
            if (ea != eb) {
                Element<V> big = sizeMap.get(ea) > sizeMap.get(eb) ? ea : eb;
                Element<V> small = big == ea ? eb : ea;
                fatherMap.put(small,big);
                sizeMap.put(big,sizeMap.get(ea)+sizeMap.get(eb));
                sizeMap.remove(small);
            }


        }

    }


}