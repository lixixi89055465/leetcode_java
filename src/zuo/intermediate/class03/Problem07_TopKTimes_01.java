package zuo.intermediate.class03;

import java.util.Comparator;
import java.util.HashMap;

public class Problem07_TopKTimes_01 {
    private static class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public static class TopRecord {
        private HashMap<String, Node> strNodeMap;
        private Node[] heap;
        private int heapSize;
        private HashMap<Node, Integer> nodeIndexMap;

        public TopRecord(int size) {
            this.heap = new Node[size];
            this.heapSize = 0;
            this.strNodeMap = new HashMap<>();
            this.nodeIndexMap = new HashMap<>();
        }

        public void add(String str) {
            Node curNode = null;
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)) {
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, 1);
            } else {
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if (preIndex == -1) {
                if (heapSize == heap.length) {
                    if (heap[0].times < curNode.times) {
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, heapSize);
                    }
                } else {
                    nodeIndexMap.put(curNode, heapSize);
                    heap[heapSize] = curNode;
                    heapInsert(heapSize++);
                }
            } else {
                heapify(preIndex, heapSize);
            }
        }

        private void heapInsert(int index) {
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times) {
                    swap(parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        private void swap(int index1, int index2) {
            nodeIndexMap.put(heap[index2], index1);
            nodeIndexMap.put(heap[index1], index2);
            Node cur = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = cur;
        }

        private void heapify(int index, int heapSize) {
            int L = index * 2 + 1;
            int R = index * 2 + 1;
            int smallest = index;
            while (L < heapSize) {
                if (heap[L].times < heap[index].times) {
                    smallest = L;
                } else if (heap[R].times < heap[smallest].times) {
                    smallest = R;
                }
                index = smallest;
                L = index * 2 + 1;
                R = index * 2 + 2;
            }

        }
    }
}
