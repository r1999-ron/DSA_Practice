package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));
    }
    


private static int lengthOfLongestSubstring(String s){
    if(s == null || s.length()==0){
        return 0;
    }
    int n = s.length();
    int maxLength = 0;
    int start = 0;
    int end = 0;
    HashMap<Character, Integer> charIndexMap = new HashMap<>();
    while(end < n){
       char currentChar = s.charAt(end);
       if(charIndexMap.containsKey(currentChar)){
         start = Math.max(start, charIndexMap.get(currentChar)+1);
       }
        charIndexMap.put(currentChar, end);
       
       if(end - start + 1 > maxLength){
         maxLength = end - start + 1;
       }
       end ++;
    }
    return maxLength;
}
}


