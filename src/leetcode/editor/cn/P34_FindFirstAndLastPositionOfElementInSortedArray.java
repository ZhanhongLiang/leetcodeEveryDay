//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 3246 👎 0


package leetcode.editor.cn;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author DY
 * @date 2026-04-17 07:58:44
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // 在此处编写本地测试逻辑

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // 左右指针二分法,
            int rightBorder = getRightBorder(nums, target);
            int leftBorder = getLeftBorder(nums, target);
            if (rightBorder == -2 || leftBorder == -2) return new int[]{-1, -1};
            if (rightBorder - leftBorder > 1){
                return new int[]{leftBorder + 1, rightBorder - 1};
            }
            return new int[]{-1,-1};
        }

        private int getRightBorder(int[] nums, int target) {
            int left = 0; // 左指针
            int right = nums.length - 1; // 右指针
            int rightBorder = -2; // 初始化有边界
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                    rightBorder = left;
                }
            }
            return rightBorder;
        }
        private int getLeftBorder(int[] nums, int target) {
            int left = 0; // 左指针
            int right = nums.length - 1; // 右指针
            int leftBorder = -2; // 初始化有边界
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] >= target) {
                    right = mid - 1;
                    leftBorder = right;
                }else {
                    left = mid + 1;
                }
            }
            return leftBorder;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}