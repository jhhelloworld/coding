package leetcode;

/**
 * jh
 * 2019年08月17日  17：51
 */
public class Q_028_ImplementStrstr {
    //思路：KMP
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null || haystack.length()<needle.length()){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        int[] next = getNextArr(ns);
        int hi = 0,ni = 0;
        while (hi<hs.length && ni < ns.length){
            if(hs[hi] == ns[ni]){
                hi++;
                ni++;
            }else if(next[ni]== -1){
                hi++;
            }else {
                ni = next[ni];
            }
        }
        return ni == ns.length?hi-ni:-1;


    }

    //next 数组
    public int[] getNextArr(char[] ns){
        if(ns.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[ns.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int pos = 2;
        while (pos<ns.length){
            if(ns[pos-1] == ns[cn]){
                next[pos++] = ++cn;
            }else if(next[cn] == -1){
                next[pos++] = 0;
            }else {
                cn = next[cn];
            }
        }
        return next;

    }



    //思路 JDK源码
    public int strStr2(String haystack, String needle) {

        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        return indexOf(hs,0,hs.length,ns,0,ns.length,0);
    }


    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

}

















