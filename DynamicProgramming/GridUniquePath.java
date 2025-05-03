package DynamicProgramming;

import java.util.Arrays;

//Using memoization
public class GridUniquePath {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        System.out.println(countWays(m,n));
    }

    static int countWays(int m, int n){
        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return countWaysUtil(m-1, n-1, dp);
    }

    static int countWaysUtil(int i, int j, int[][] dp){
        if(i==0 || j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = countWaysUtil(i-1, j, dp);
        int down = countWaysUtil(i, j-1, dp);

        return up + down;
    }
}
