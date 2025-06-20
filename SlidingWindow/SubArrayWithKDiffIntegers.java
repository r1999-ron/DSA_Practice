package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

/**
 * You are given an integer array nums and an integer k. Your task is to return
 * the number of good subarrays of nums.
 * 
 * A good subarray is a contiguous subarray that contains exactly k distinct
 * integers. For example, in the array
 * [1,2,3,1,2], the subarray [1,2,3] contains 3 distinct integers:
 * 
 * Constraints:
 * 
 * 1
 * ≤
 * 1≤
 * nums.length
 * ≤
 * 2
 * ∗
 * 1
 * 0
 * 4
 * ≤2∗10
 * 4
 * 
 * 
 * 1
 * ≤
 * 1≤
 * nums[i], k
 * ≤
 * ≤
 * nums.length
 */

public class SubArrayWithKDiffIntegers {
    public static void main(String[] args) {
        int[][] testcases = {
                { 3, 3, 3 },
                { 1 },
                { 1, 2, 3, 4, 5 },
                { 1, 2, 1, 2, 3 },
                { 1, 2, 1, 3, 4 }
        };
        int[] ks = { 2, 1, 3, 2, 3 };
        for (int i = 0; i < ks.length; i++) {
            int result = subarraysWithKDistinct(testcases[i], ks[i]);
            System.out.println((i + 1) + ".\tnums: " + Arrays.toString(testcases[i]) + ", k: " + ks[i]);
            System.out.println("\tresult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int count = 0;
        int left = 0;
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            fmap.put(nums[right], fmap.getOrDefault(nums[right], 0) + 1);
            if (fmap.get(nums[right]) == 1) {
                k--;
            }
            while (k < 0) {
                fmap.put(nums[left], fmap.get(nums[left]) - 1);
                if (fmap.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;

    }
}