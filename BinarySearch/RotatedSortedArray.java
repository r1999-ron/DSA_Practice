package BinarySearch;

public class RotatedSortedArray{
    public static void main(String[] args){
        int[] A1 = {4,5,6,7,0,1,2,3};
        int B1 = 4;
        System.out.println(search(A1,B1));

        int[] A2 = {5,17,100,3};
        int B2 = 6;
        System.out.println(search(A2,B2));
    }

    private static int search(int[] A, int B) {

        int left=0;
        int right = A.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(A[mid]==B){
                return mid;
            }
            if(A[left]<=A[mid]){
                if(A[left]<=B && B<A[mid]){
                    right = mid-1; 
                }else{
                    left = mid+1;
                }
            }else{
                if(A[mid]<B && B<=A[right]){
                    left = mid+1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

