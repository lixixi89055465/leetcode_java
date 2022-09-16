package zuo.Advanced2019.class02;


import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class
Code04_UnionFind {
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<Element<V>>();

            while (fatherMap.get(element) != element) {
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

        public void Union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> heada = findHead(elementMap.get(a));
                Element<V> headb = findHead(elementMap.get(b));
                if (heada != headb) {
                    Element<V> big = sizeMap.get(heada) >= sizeMap.get(headb) ? heada : headb;
                    Element<V> small = sizeMap.get(heada) >= sizeMap.get(headb) ? headb : heada;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(heada) + sizeMap.get(headb));
                    sizeMap.remove(small);
                }

            }
        }


    }
}
