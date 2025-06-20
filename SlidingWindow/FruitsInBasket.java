package SlidingWindow;

import java.util.*;

public class FruitsInBasket {
    public static void main(String[] args) {
        int[][] fruits = { { 3, 4, 2, 1, 3, 2 },
                { 2, 2, 2, 3, 1, 2, 4, 4, 4, 4 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 2, 3, 4, 1, 3, 3, 1, 2, 3, 4, 1, 5, 2, 5, 7, 7 },
                { 5, 4, 3, 2, 1, 1 } };

        for (int i = 0; i < fruits.length; i++) {
            System.out.print((i + 1) + ".\tFruits: [");
            for (int j = 0; j < fruits[i].length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(fruits[i][j]);
            }
            System.out.println("]");
            System.out.println("\n\tMaximum number of fruit(s) collected: " + totalFruit(fruits[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();

        int collected = 0;
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            baskets.put(fruits[right], baskets.getOrDefault(fruits[right], 0) + 1);
            while (baskets.size() > 2) {
                baskets.put(fruits[left], baskets.get(fruits[left]) - 1);
                if (baskets.get(fruits[left]) == 0) {
                    baskets.remove(fruits[left]);
                }
                left++;
            }
            collected = Math.max(collected, right - left + 1);
        }
        return collected;

    }

}
