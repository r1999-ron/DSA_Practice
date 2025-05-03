package DynamicProgramming;

public class GridUniquePathSpaceOptimization {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        // Call the countWays function and print the result
        System.out.println(countWays(m, n));
    }
    static int countWays(int m, int n){
        int[] prev = new int[n];
        for(int i=0; i<m; i++){
            int[] temp = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                }
                int up=0;
                int left = 0;
                if(i>0)
                  up = prev[j];
                if(j>0)
                  left = temp[j-1];

                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
