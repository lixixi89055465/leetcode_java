package base.class04;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_Comparator {
    static class Student {
        private int id;
        private int age;

        public Student(int id, int age) {
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator
            implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        heap.add(new Student(1,1));
        heap.add(new Student(5,1));
        heap.add(new Student(9,1));
        heap.add(new Student(3,1));
        while (!heap.isEmpty()){
            System.out.println(heap.poll().id);
        }
    }
}
