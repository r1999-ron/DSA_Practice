package BinarySearch;

import java.util.Arrays;

public class SearchForRange{
    public static void main(String[] args){
        int[] A = {5,7,7,8,8,10};
        int B = 8;
        System.out.println(Arrays.toString(searchRange(A,B)));
    }

    private static int[] searchRange(final int[] A, int B) {
       int[] result = {-1,-1};
       int firstIndex = findStartIndex(A,B);
       int secondIndex = findEndIndex(A,B);

       if(firstIndex!= -1 && secondIndex != -1){
        result[0] = firstIndex;
        result[1] = secondIndex;
       }
       return result;

    }
    private static int findStartIndex(int[] A, int B){
        int start = 0;
        int end = A.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(A[mid]==B){
                result = mid;
                end = mid - 1;
            }else if(A[mid]<B){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }
    private static int findEndIndex(int[] A, int B){
        int start = 0;
        int end = A.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(A[mid]==B){
                result = mid;
                start = mid+1;
            }else if(A[mid]<B){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }
}