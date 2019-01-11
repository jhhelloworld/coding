package leetcode;

/**
 * jh
 * 2019年01月11日  14：54
 */
/**
 * jh
 * 2019年01月11日  14：01
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class Q_709_ToLowerCase {
    public static String toLowerCase(String str) {
        if(str == null || str.length()==0)
            return str;
        int diff = 'a' - 'A';
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(chars[i]<='Z' && chars[i]>='A'){
                chars[i] = (char)(chars[i]+diff);
            }
        }
        //chars.toString 乱码
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = "He";
        System.out.println(toLowerCase(s));
    }


}