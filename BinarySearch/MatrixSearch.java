package BinarySearch;

public class MatrixSearch{
    public static void main(String[] args){
        int[][] A = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int B = 3;
        System.out.println(searchMatrix(A,B));
    }

    private static int searchMatrix(int[][] A, int B) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }
        int M = A[0].length;

        if (M == 0) {
            return 0;
        }

        int low = 0;
        int high = N * M - 1;
        while(low <=high){
            int mid = low + (high-low)/2;
            int element = A[mid / M][mid % M]; // Corrected indices
            if(element == B){
                return 1;
            }else if(element < B){
                low = mid + 1;

            }else{
                high = mid - 1;
            }
        }
        return 0;
    }
}
