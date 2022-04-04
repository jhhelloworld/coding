package zcy_算法与数据结构进阶班.trainingcamp001.class01;

import java.util.Stack;

/**
 * 子数组的最小值之和
 * 给定一个整数数组 arr，找到 min(b)的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 */
// subArrayMinSum1是暴力解
// subArrayMinSum2是最优解的思路
// sumSubarrayMins是最优解思路下的单调栈优化
// Leetcode上只提交sumSubarrayMins方法，时间复杂度O(N)，可以直接通过
public class Code05_SumOfSubarrayMinimums {

    public static int subArrayMinSum1(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int min = arr[i];
                for (int k = i + 1; k <= j; k++) {
                    min = Math.min(min, arr[k]);
                }
                ans += min;
            }
        }
        return ans;
    }

    public static int subArrayMinSum2(int[] arr) {
        int[] left = leftNearLessEqual2(arr);
        int[] right = rightNearLess2(arr);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i - left[i];
            int end = right[i] - i;
            ans += start * end * arr[i];
        }
        return ans;
    }

    public static int[] leftNearLessEqual2(int[] arr) {
        int N = arr.length;
        int[] left = new int[N];
        for (int i = 0; i < N; i++) {
            int ans = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    ans = j;
                    break;
                }
            }
            left[i] = ans;
        }
        return left;
    }

    public static int[] rightNearLess2(int[] arr) {
        int N = arr.length;
        int[] right = new int[N];
        for (int i = 0; i < N; i++) {
            int ans = N;
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    ans = j;
                    break;
                }
            }
            right[i] = ans;
        }
        return right;
    }

    public static int sumSubarrayMins(int[] arr) {
        //注意： left 数组是 左侧第一个小于或者等于当前值的下标，right 是小于当前值
        //这样设计是为了避免重复统计
        //假设数组[b,a,c,a,d],其中 a 是数组中最小的元素，有两个a
        //如果左右数组都是比当前值小的坐标，第一个a 对应的左右数组是 [b,a]和[a,c] 第二个a对应的左右数组是 [c,a]和[a,d]
        //类似[a,c,a,d] 最小值也是a，但是没被统计
        //如果左右数组都是小于等于当前值的下标，两个a对应的子数组都是整个数组，统计重复
        //按照代码中的规则进行划分，第一个a 对应的左右数组是 [b,a] 和 [a,c,a,d]
        // 第二个a对应的左右数组是 [c,a] 和[a,d] 没有重复
        int[] left = nearLessEqualLeft(arr);
        int[] right = nearLessRight(arr);
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            long start = i - left[i];
            long end = right[i] - i;
            // 注意： 这里是乘号
            //原因：i-left[i] 左边数组最大长度(包括当前元素) 假设长度为M
            //  rigt[i] - i 右边数组最大长度(包括当前元素) 假设长度为N
            //左右两侧自由排列组合，必须包含i, 所以共有M*N中方式，最小值都是arr[i]
            //防止溢出，进行类型转换
            ans += start * end * (long) arr[i];
            ans %= 1000000007;
        }
        return (int) ans;
    }

    //注意，只需要单边
    public static int[] nearLessEqualLeft(int[] arr) {
        int N = arr.length;
        int[] left = new int[N];
        Stack<Integer> stack = new Stack<>();
        // 倒序，从右遍历，如果比栈顶大，直接入栈
        // 如果 <= 栈顶（注意，由于是从右向左遍历，栈里的元素都是右边的），弹出，弹出元素左边第一个比他小的就是当前元素
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }
        return left;
    }

    public static int[] nearLessRight(int[] arr) {
        int N = arr.length;
        int[] right = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = N;
        }
        return right;
    }

    public static int[] randomArray(int len, int maxValue) {
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue) + 1;
        }
        return ans;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 50;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * maxLen);
            int[] arr = randomArray(len, maxValue);
            int ans1 = subArrayMinSum1(arr);
            int ans2 = subArrayMinSum2(arr);
            int ans3 = sumSubarrayMins(arr);
            if (ans1 != ans2 || ans1 != ans3) {
                printArray(arr);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束");
    }


    /**
     * leetcode 时间最优解
     */
    public static int sumSubarrayMins3(int[] arr) {
        int ans = 0, top = -1, lastSum = 0, mod = 1_000_000_007, size = arr.length;
        int[] weights = new int[size], stack = new int[size];
        for (int num : arr) {
            int weight = 1;
            while (top >= 0 && num < stack[top]) {
                //比栈顶元素小
                weight += weights[top];
                lastSum -= stack[top] * weights[top];
                --top;
            }
            stack[++top] = num;
            weights[top] = weight;

            lastSum += weight * num;
            if (lastSum >= mod) {
                lastSum -= mod;
            }
            ans = (ans + lastSum);
            if (ans >= mod) {
                ans -= mod;
            }
        }
        return ans;
    }



}
