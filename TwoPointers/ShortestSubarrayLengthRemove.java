package TwoPointers;

public class ShortestSubarrayLengthRemove {
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,4,2,3,5};
        int N = arr.length;
        System.out.println(lengthOfShortesSubarray(arr,N));
    }

    private static int lengthOfShortesSubarray(int[] arr, int N){
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;
        while(left < right && arr[left+1] >= arr[left]){
            left++;
        }
        if(left == N-1){
            return 0;
        }
        while(right > left && arr[right-1] <= arr[right]){
            right --;
        }
        minLength = Math.min(N-left-1, right);

        int j = right;
        for(int i=0; i<left+1; i++){
            if(arr[i] <= arr[j]){
                minLength = Math.min(minLength, j-i-1);
            }else if(j < N-1){  // 1 <= 2 --> minLength = (4,4) = 4
                j++;
            }else{
                break;
            }
        }
        return minLength;
    }
}
