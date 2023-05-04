package zuo.intermediate.class03;

import java.util.Comparator;
import java.util.HashMap;

public class Problem07_TopKTimes {
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
            heap = new Node[size];
            this.heapSize = 0;
            strNodeMap = new HashMap<String, Node>();
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

        public void swap(int index1, int index2) {
            nodeIndexMap.put(heap[index1], index2);
            nodeIndexMap.put(heap[index2], index1);
            Node cur = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = cur;
        }

        private void heapify(int index, int heapSize) {
            int L = index * 2 + 1;
            int R = index * 2 + 2;
            int smallest = index;
            while (L < heapSize) {
                if (heap[L].times < heap[index].times) {
                    smallest = L;
                }
                if (R < heapSize && heap[R].times < heap[smallest].times) {
                    smallest = R;
                }
                if (smallest != index) {
                    swap(index, smallest);
                } else {
                    break;
                }
                index = smallest;
                L = index * 2 + 1;
                R = index * 2 + 2;
            }
        }

        public void printTopK() {
            System.out.println("TOP: ");
            for (int i = 0; i != heap.length; i++) {
                if (heap[i] == null) {
                    break;
                }
                System.out.println("Str:" + heap[i].str);
                System.out.println(" times:" + heap[i].times);
            }
        }

    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.times - o1.times;
        }
    }

    public static void printTopKAndRank(String[] arr, int topK) {
        if (arr == null || arr.length == 0 || topK < 1) {
            return;
        }

    }
}
