package StackAndQueue;

import java.util.Stack;

public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] elevationMap1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result1 = RainWaterTrapped.trapRainwater(elevationMap1);
        System.out.println("Result 1: " + result1); // Output should be 6

        int[] elevationMap2 = { 1, 2 };
        int result2 = RainWaterTrapped.trapRainwater(elevationMap2);
        System.out.println("Result 2: " + result2); // Output should be 0
    }

    public static int trapRainwater(int[] A) {
        if (A == null || A.length <= 2) {
            return 0; // Not enough bars to trap water
        }

        int n = A.length;
        int totalWater = 0;
        Stack<Integer> stack = new Stack<>();

        for (int current = 0; current < n; current++) {
            while (!stack.isEmpty() && A[current] > A[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break; // No left boundary to trap water
                }

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(A[current], A[stack.peek()]) - A[top];
                totalWater += distance * boundedHeight;
            }

            stack.push(current);
        }

        return totalWater;
    }
}
