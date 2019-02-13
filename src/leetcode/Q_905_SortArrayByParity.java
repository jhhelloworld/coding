package leetcode;

import a_test.A;

/**
 * jh
 * 2019年01月11日  17：28
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class Q_905_SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if(A==null || A.length<2)
            return A;
        int left = 0;
        int right = A.length-1;
        while (left<right){
            if(A[left]%2!=0){
                swap(A,left,right);
                right--;
            }else {
                left++;
            }
        }
        return A;
    }

    public void  swap(int[] A,int l,int r){
        int tmp = A[l];
        A[l] = A[r];
        A[r] = tmp;
    }
}