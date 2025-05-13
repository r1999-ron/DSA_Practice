package BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        System.out.println(solve(arr1));

        int[] arr2 = {5,17,100,11};
        System.out.println(solve(arr2));
    }

    private static int solve(int[] A){
        if(A.length == 1){
            return A[0];
        }
        if(A[0] >= A[1]){
            return A[0];
        }
        if(A[A.length-1] > A[A.length-2]){
            return A[A.length-1];
        }
        int l=0, h=A.length-2;
        while(l<=h){
            int m = l + (h-l)/2;
            if(A[m]>=A[m-1] && A[m]>=A[m+1]){
                return A[m];
            }else if(A[m] < A[m-1] && A[m]>=A[m+1]){
                h = m-1;
            }else{
                l=m+1;
            }
        }
        return -1;
    }
   
}

//5,17,100,11
