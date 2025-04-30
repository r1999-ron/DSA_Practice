package DynamicProgramming;
//https://leetcode.com/problems/maximum-sum-of-subsequence-with-non-adjacent-elements/description/
import java.util.*;

public class MaximumSumSubsequenceSpaceOptimization {
    static int solve(int n, int[] arr) {
        // Initialize variables to keep track of the maximum sums at the current and previous positions.
        int prev = arr[0];
        int prev2 = 0;

        // Iterate through the array starting from the second element.
        for (int i = 1; i < n; i++) {
            // Calculate the maximum sum by either picking the current element or not picking it.
            int pick = arr[i];

            // If there are at least two elements before the current element, add the value from prev2.
            if (i > 1)
                pick += prev2;

            // The non-pick option is to use the maximum sum from the previous position.
            int nonPick = prev;

            // Calculate the maximum sum for the current position and update prev and prev2.
            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }

        // The 'prev' variable now holds the maximum possible sum.
        return prev;
    }

    public static void main(String args[]) {
        // Input array with elements.
        int arr[] = {2, 1, 4, 9};

        // Get the length of the array.
        int n = arr.length;

        // Call the solve function to find the maximum possible sum.
        int result = solve(n, arr);

        // Print the result.
        System.out.println(result);
    }
}
//TC = O(N)
// SC = O(1)