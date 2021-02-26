package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

//public class Main {
//    public static void main(String[] args) {
//        int i = 0;
//        int res = 1;
//        while(true) {
//            try {
//                res += res / (i++);
//                System.out.println("No exception");
//            } catch(Exception e) {
//                System.out.println("Zero exception");
//            } finally {
//                System.out.print("In finally clause");
//                System.out.println(i);
//                if (i == 2) break;
//            }
//        }
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        ArrayList<String> l1 = new ArrayList<String>();
//        ArrayList<Integer> l2 = new ArrayList<Integer>();
//        l1.add("1");
//        l2.add(1);
//        System.out.println(l1.get(0).getClass());
//        System.out.println(l2.get(0).getClass());
//        System.out.println(l1.getClass() == l2.getClass());
//    }
//}
class Main{
    public static void main(String[]args){
        int i=3;
        System.out.println((i++)+(i++)+(i++));
    }
}


