package leetcode;

/**
 * jh
 * 2019年11月11日  14：11
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Q_240_searchA2dMatrixIi {
    /**
     * 普通方法
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        //预处理
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        //游标位置
        int rol = matrix.length - 1;
        int col = 0;
        while (rol >= 0 && col < matrix[0].length) {
            if (matrix[rol][col] < target) {
                col++;
            } else if (matrix[rol][col] > target) {
                rol--;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 二分查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (matrix[i][j] == target) {
                return true;
            }
            //当点值大于target，在当前列找小于等于target的最大值
            if (matrix[i][j] > target) {
                i = getFirstLessOrEqualIndex(matrix, j, target);
                if (i == -1) {
                    return false;
                }
            } else {
                //当前值小于target，在当前行找大于等于target的最小值
                j = getFirstMoreOrEqualIndex(matrix[i], target);
                if (j == -1) {
                    return false;
                }
            }
        }
        return false;
    }


    //查找小于等于target的最大值
    private int getFirstLessOrEqualIndex(int[][] matrix, int colNum, int target) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int left = 0, right = matrix.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][colNum] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (matrix[right][colNum] <= target) {
            return right;
        } else if (matrix[left][colNum] <= target) {
            return left;
        } else {
            return -1;
        }


    }

    //查找大于等于target的最小值
    private int getFirstMoreOrEqualIndex(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else if (nums[right] >= target) {
            return right;
        } else {
            return -1;
        }

    }
}