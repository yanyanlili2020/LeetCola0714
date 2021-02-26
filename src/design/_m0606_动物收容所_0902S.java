package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 链接：https://leetcode-cn.com/problems/animal-shelter-lcci/
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，
 * 或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，
 * 实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。
 * 允许使用Java内置的LinkedList数据结构。
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 */
public class _m0606_动物收容所_0902S {
    class AnimalShelf {
        Queue<int[]> queue;
        public AnimalShelf() {
            queue = new LinkedList<>();
        }
        public void enqueue(int[] animal) {
            queue.offer(animal);
        }
        public int[] dequeueAny() {
            if(queue.isEmpty())
                return new int[]{-1, -1};
            return queue.poll();
        }
        public int[] dequeueDog() {
            for(int[] animal : queue)
                if(animal[1] == 1) {
                    queue.remove(animal);
                    return animal;
                }
            return new int[]{-1, -1};
        }
        public int[] dequeueCat() {
            for(int[] animal : queue)
                if(animal[1] == 0) {
                    queue.remove(animal);
                    return animal;
                }
            return new int[]{-1, -1};
        }
    }
    /**
     * Your AnimalShelf object will be instantiated and called as such:
     * AnimalShelf obj = new AnimalShelf();
     * obj.enqueue(animal);
     * int[] param_2 = obj.dequeueAny();
     * int[] param_3 = obj.dequeueDog();
     * int[] param_4 = obj.dequeueCat();
     */
    class AnimalShelf2 {
        private final int DOG = 1;
        private final int CAT = 0;
        private Node head, tail;
        private int[] NONE = {-1, -1};
        public AnimalShelf2() {
            head = new Node(-1, -1);
            head.prev = head.next = head;
            tail = head;
        }
        public void enqueue(int[] animal) {
            addLast(animal);
        }
        private void addLast(int[] animal) {
            Node n = new Node(animal[0], animal[1]);
            n.prev = tail;
            n.next = tail.next;
            tail.next.prev = n;
            tail.next = n;
            tail = n;
        }
        public int[] dequeueAny() {
            if(head == tail)
                return NONE;
            Node n = head.next;
            remove(n);
            return new int[]{n.no, n.type};
        }
        public int[] dequeueDog() {
            return dequeueType(DOG);
        }
        public int[] dequeueCat() {
            return dequeueType(CAT);
        }
        private int[] dequeueType(int type) {
            Node n = head.next;
            while(n != head && n.type != type) {
                n = n.next;
            }
            if(n == head)
                return NONE;
            remove(n);
            return new int[]{n.no, n.type};
        }
        private void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            if(n == tail) {
                tail = n.prev;
            }
            n.prev = n.next = null;
        }
    }
    class Node {
        int type;
        int no;
        Node prev, next;
        Node(int no, int type) {
            this.no = no;
            this.type = type;
        }
    }
/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */
}
