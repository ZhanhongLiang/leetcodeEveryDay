//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 4238 👎 0


package leetcode.editor.cn;

/**
 * 最长递增子序列
 * @author DY
 * @date 2026-04-29 23:22:18
 */
public class P300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //dp[i]表示i之前包括i的以nums[i]结尾的最⻓递增⼦序列的⻓度
            // 先背包后物品顺序
            // 初始化
            // dp[i] 表示以 nums[i] 结尾的最长严格递增子序列长度
            if (nums.length <= 1) {
                return nums.length;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1); // 这个是初始化参数,全部初始为0
            int res = 1; // 前面已经边界判断，怎么至少有1个长度
            // 先背包后物品
            for (int i = 1; i < nums.length; i++) {
                for(int j = 0; j < i; j++) {
                    // 因为需要递增非连续子序列，所以需要判断大小
                    if(nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                // res结果保存
                res = Math.max(res, dp[i]); // 因为dp[i]不一定是存当前最长的
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}