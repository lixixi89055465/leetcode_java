package zuo.base.chass01;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;

import java.util.HashMap;

public class Code0_RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
        }

        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }

        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);

                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);

            }
        }

        public K getRandomKey() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size);
            return this.indexKeyMap.get(randomIndex);
        }

    }
}
