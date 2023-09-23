package BinarySearch;

public class RotatedArray {
    public static void main(String[] args){
    int[] A = {7,2,4,5};
    System.out.println(findMin(A));
}

    private static int findMin(int[] A) {
        int left = 0;
        int right = A.length-1;
        while(left < right){
            if(A[left] < A[right]){
                return A[left];  // This one in case of sorted array
            }
            int mid = left + (right-left)/2;
            if(A[mid]>=A[left]){    //7,6,2,4,
                 left = mid+1;
            }else{
                right = mid;
            }
        }
        return A[left];
    }

    
}
