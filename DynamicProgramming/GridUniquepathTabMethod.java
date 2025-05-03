package DynamicProgramming;

import java.util.Arrays;

//Tabulation Method

public class GridUniquepathTabMethod {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        // Call the countWays function and print the result
        System.out.println(countWays(m, n));
    }
    static int countWays(int m, int n) {
        // Create a 2D DP array to store the results
        int dp[][] = new int[m][n];

        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Call the countWaysUtil function to calculate and return the result
        return countWaysUtil(m, n, dp);
    }

    static int countWaysUtil(int m, int n, int[][] dp){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0){
                    up = dp[i-1][j];
                }
                if(j>0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
}
