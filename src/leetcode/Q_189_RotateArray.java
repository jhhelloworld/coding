package leetcode;

/**
 * jh
 * 2019年09月05日  13：22
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 */
public class Q_189_RotateArray {


    //方法1：数组翻转
    public void rotate(int[] nums, int k) {

        //容易忘
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //方法2 直接交换 第0位移到第k位，第k位移到第 （k+k）%len位，直到某一位移到第0位
    //这种方法可能会有个问题，如果 n%k==0 。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。移动到的所有下标 i%k=0
    //解决这个问题的思路：
    //假设n%k等于0 第一次移动了 n/k个元素，下一次移动 i%k==1的元素，一直到再次遇到 i%k=0

    //这是有问题的代码
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k %= nums.length;
        int index = k;
        int num = nums[0];

        while (index != 0) {
            int temp = nums[index];
            nums[index] = num;
            num = temp;
            index = (index + k) % nums.length;
        }
        //最后给0赋值
        nums[0] = num;

    }

    //修改后的代码
    public  void rotate3(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        //记录有效移动次数
        int moveTime = 0;
        int startIndex = 0;
        //移动的总次数小于等于数组的长度，当回到原点时 ，内循环终止，外循环起始位置加一
        while (moveTime < nums.length) {
            int targetIndex = (startIndex + k) % len;
            int number = nums[startIndex];
            while (targetIndex != startIndex) {
                int temp = nums[targetIndex];
                nums[targetIndex] = number;
                targetIndex = (targetIndex + k) % len;
                number = temp;
                moveTime++;
            }
            //给start赋值
            nums[startIndex] = number;
            //这一步别忘加一
            moveTime++;
            //重新开始下一轮循环
            startIndex++;
        }
    }


    //时间复杂度o(nk)，空间复杂度 o(1)
    public void rotate4(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    //使用额外的数组
    public void rotate5(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println();
    }


}






















