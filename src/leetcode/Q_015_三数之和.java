package leetcode;

import java.util.*;

/**
 * jh
 * TODO 542. 01 Matrix
 * TODO 全排列
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Q_015_三数之和 {

    //测试用例 {-2,-2,1,1,1,0,2,4}
    //缺点：用到了排序
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            //重点在于怎么过滤重复值
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;

    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> resultItem = new ArrayList<>();

                if (j != i + 1 && nums[j] == nums[j - 1] && j != nums.length - 1) {
                    continue;
                }
                if (set.contains(target - nums[j])) {
                    resultItem.add(nums[i]);
                    resultItem.add(target - nums[j]);
                    resultItem.add(nums[j]);
                    result.add(resultItem);
                    set.add(nums[j]);
                    continue;
                } else {
                    set.add(nums[j]);
                }


            }
        }
        return result;

    }


    //高赞回答
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            //剪枝  及时失败
            if(nums[i]> 0){
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i+1, hi = nums.length-1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        //通过这一步避免了方法一的判断
                        while (lo < hi && nums[lo] == nums[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi-1]) {
                            hi--;
                        }
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

}