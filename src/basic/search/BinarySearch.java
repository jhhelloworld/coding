package basic.search;

/**
 * @author Jianghua
 * 2018年11月05日  14：41
 * 二分查找，以单调不减序列为例
 */
public class BinarySearch {


    /**
     * 最接近目标的数
     */
    public int findClosest(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            //通过这个判断，如果数组中不包含target，剩余的两个值必然是离target最近的两个数
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.abs(arr[left] - target) < Math.abs(arr[right] - target) ? left : right;
    }

    /**
     * 第一次出现的位置
     */
    public static int findFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    /**
     * 最后一次出现的位置
     */
    public static int findLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 第一个小于target的数
     */
    public int findLargestSmallerOfTarget(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < target) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target && left != 0) {
            return left - 1;
        } else if (nums[left] == target && left == 0) {
            return -1;
        } else {
            return left;
        }
    }

    /**
     * 第一个大于target 的数
     */
    public int findSmallesrLargetOfTargest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < target) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target && right != nums.length - 1) {
            return right + 1;
        } else if (nums[right] == target && right == nums.length - 1) {
            return -1;
        } else {
            return right;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3};
        System.out.println(nums);
        System.out.println(findFirst(nums, 2));
        System.out.println(findLast(nums, 2));




    }



}