package StackAndQueue;

import java.util.*;

public class LargestRectangleHistogram {

    public static void main(String[] args) {

        int[] A1 = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(A1));

        int[] A2 = { 2 };
        System.out.println(largestRectangleArea(A2));

    }

    private static int largestRectangleArea(int[] A) {
        int[] ps = previousSmaller(A);
        int[] ns = nextSmaller(A);
        int maxAns = 0;

        for (int i = 0; i < A.length; i++) {
            int current = (ns[i] - ps[i] - 1) * A[i];

            maxAns = Math.max(maxAns, current);
        }
        return maxAns;
    }

    private static int[] previousSmaller(int[] A) {
        int[] ps = new int[A.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!s.isEmpty() && A[s.peek()] >= A[i]) {
                s.pop();
            }
            if (s.empty()) {
                ps[i] = -1;
            } else {
                ps[i] = s.peek();
            }
            s.push(i);
        }
        return ps;
    }

    private static int[] nextSmaller(int[] A) {
        int[] ns = new int[A.length];
        Stack<Integer> s = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && A[i] <= A[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ns[i] = A.length;
            } else {
                ns[i] = s.peek();
            }
            s.push(i);
        }
        return ns;
    }

}
