package a_test;

import java.util.*;

/**
 * jh
 * 2019年09月15日  16：05
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class PracticeAtHome4 {

    public int[] intersect(int[] nums1, int[] nums2) {
        //定义map存储nums1的值和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.get(num) != null && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = result.get(i);
        }
        return array;

    }


    public int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        // First sort the two arrays to adopt an approach similar to binary search.
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1 = 0, idx2 = 0; // create two index pointers
        int len = Math.min(len1, len2); // the max length an intersection can get
        int[] intersect = new int[len]; // use array for faster manipulations (always faster than lists!)
        int idx = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            // Get the current two corresponding elements in the two arrays.
            int current1 = nums1[idx1], current2 = nums2[idx2];
            // If they are equal, add to the intersect list and increment both pointers
            // to point to the next elements in both arrays.
            if (current1 == current2) {
                intersect[idx++] = current1;
                idx1++;
                idx2++;
            } else if (current1 > current2) { // If the element in nums1[] is bigger, increment the second pointer.
                idx2++;
            } else { // Else increment the first pointer
                idx1++;
            }
        }
        return Arrays.copyOfRange(intersect, 0, idx); // Java array slicing
    }

}
