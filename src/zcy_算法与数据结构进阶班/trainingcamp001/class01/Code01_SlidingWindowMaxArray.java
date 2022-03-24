package zcy_算法与数据结构进阶班.trainingcamp001.class01;

import java.util.LinkedList;

/**
 * 窗口内最大值或最小值更新结构的实现
 * 假设一个固定大小为W的窗口，依次划过arr，
 * 返回每一次滑出状况的最大值
 * 例如，arr = [4,3,5,4,3,3,6,7], W = 3
 * 返回：[5,5,5,4,6,7]
 */

/**
 * 思路：维护一个双端队列
 * 入队规则：滑动窗口每向右移动一步，就把最右边的值所对应的下标放入队尾。
 * 假设窗口滑动后，窗口最右边对应的下标是R， 在入队前需要做以下检验：
 * 依次比较队尾对应的数值，如果队尾对应的数值<= arr[R] ,则把队尾下标弹出，队尾对应的数值 > arr[R] 或者队列为空
 * 所以队列中的元素一定是单调递减的。
 * 如果队列头部的下标已经划过了窗口(下标== R-w),弹出这个过期元素
 * 为什么这样做：
 * 核心思想是在队列中记录每一步可能的最大值。窗口最右边一定是当前窗口最后一个从窗口中划过的数字，而且既然窗口最右边已经比队列中某些值大了
 * 所以队列中没有必要存储比arr[R] 小或者相等的值。
 * 比 arr[R] 大的值还是需要存储的，而且当窗口划过的时候要及时淘汰。
 *
 * 时间复杂度分析：每个元素会入队一次，出队一次，所以复杂度是O(N)
 */
public class Code01_SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 其中放的是位置，头代表 （大->小）尾
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        // L...R
        //     i
        for (int R = 0; R < arr.length; R++) { // 当前让 i -> [i] 进窗口 ， i 就是 r
            // R -> 值  可以放在比他大的数后，或者空
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            // 数进来了
            // 如果窗口没有形成W的长度之前，不弹出数字的
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            // 以上窗口更新做完了
            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    // for test
    public static int[] rightWay(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        int L = 0;
        int R = w - 1;
        while (R < arr.length) {
            int max = arr[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, arr[i]);

            }
            res[index++] = max;
            L++;
            R++;
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int w = (int) (Math.random() * (arr.length + 1));
            int[] ans1 = getMaxWindow(arr, w);
            int[] ans2 = rightWay(arr, w);
            if (!isEqual(ans1, ans2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

}
