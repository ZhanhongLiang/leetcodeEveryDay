//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 👍 512 👎 0


package leetcode.editor.cn;

/**
 * 最长连续递增序列
 * @author DY
 * @date 2026-06-03 11:25:15
 */
public class P674_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P674_LongestContinuousIncreasingSubsequence().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length < 1)  return 0;
            // dp[i] 代表包含i当前下标最长的连续子序列长度
            int[] dp = new int[nums.length];
            // 初始化
            Arrays.fill(dp, 1); // 怎么初始都是至少有一个长度
            int res = 1;
            for (int i = 1; i < nums.length; i++) {
                // 因为i 是由 i -1 可以推导出来，也就是连续改变了转移状态
                if (nums[i] > nums[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[i - 1] + 1);
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}