package leetcode;

/**
 * jh
 * 2019年01月04日  14：10
 */
public class Q_002LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abababc"));
    }


    public static int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }
        char[] charArray = s.toCharArray();
        int len = 1;
        int slow = 1;
        int max = 1;
        int fast = 1;
        char cur;
        for(fast = 1;fast< charArray.length;fast++){
            cur = charArray[slow];
            if(cur!=charArray[fast]){
                len++;
            }else {
                slow = fast;
                max = Math.max(max,len);
                len = 0;
            }
        }
        return Math.max(max,len);



    }
}