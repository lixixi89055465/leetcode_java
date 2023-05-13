package zuo.intermediate.class03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_29_TopKTimes2 {
    private static class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    private static class TopRecord {
        private HashMap<String, Node> strNodeMap = new HashMap<>();
        private HashMap<Node, Integer> nodeIndexMap = new HashMap<>();
        private Node[] heap;
        private int index;

        public TopRecord(int K) {
            heap = new Node[K];
            index = 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }


        public void add(String str) {
            Node curNode = null;
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)) {
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, -1);
            } else {
                curNode = strNodeMap.get(curNode);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if (preIndex == -1) {
                if (index == heap.length) {
                    if (heap[0].times < curNode.times) {
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        modify(0, index);
                    }
                } else {
                    nodeIndexMap.put(curNode, index);
                    heap[index] = curNode;
                    heapInsert(index++);
                }
            } else {
                modify(preIndex, index);
            }

        }

        private void heapInsert(int index) {
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[parent].times > heap[index].times) {
                    swap(parent, index);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        private void swap(int parent, int index) {
            Node tmp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = tmp;
            nodeIndexMap.put(heap[parent], parent);
            nodeIndexMap.put(heap[index], index);
        }

        private void modify(int preIndex, int heapSize) {
            int l = index * 2 + 1;
            int r = index * 2 + 2;
            int smallest = index;
            while (l < heapSize) {
                if (heap[l].times < heap[index].times) {
                    smallest = l;
                }
                if (r < heapSize && heap[r].times < heap[smallest].times) {
                    smallest = r;
                }
                index = smallest;
                l = index * 2 + 1;
                r = index * 2 + 1;
            }

        }
    }
}
