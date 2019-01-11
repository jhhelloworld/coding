package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * jh
 * 2019年01月11日  15：14
 *
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 * Input: [1,2,3,3]   Output: 3
 * Input: [2,1,2,5,3,2]  Output: 2
 * Input: [5,1,5,2,5,3,5,4] Output: 5
 */
public class Q_961_NoRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int a: A){
            if(set.contains(a)){
                return a;
            }else {
                set.add(a);
            }
        }
        return 0;

    }
}