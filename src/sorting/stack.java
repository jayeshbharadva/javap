package sorting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.add(1);
        s.add(2);
        System.out.println(s.peek());

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(3);
        q.add(5);
        System.out.println(q.peek());
        char ch = '1';
//        int d = ch.charAt(0);
        System.out.println((int)ch);
        int a = 10;

        }
}
