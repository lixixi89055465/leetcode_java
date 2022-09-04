package base.class04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Code03_Heap02 {
    public static class MyHeap<T> {
        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> com) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            comparator = com;
        }

    }
}
