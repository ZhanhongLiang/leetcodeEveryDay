//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2548 👎 0


package leetcode.editor.cn;

/**
 * 分割等和子集
 * @author DY
 * @date 2026-04-25 22:54:42
 */
public class P416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int[] dp = new int[10001]; // 本经典01背包, 因为大小不超过100，且数量不超过200个，且为总和一半
            // 初始化
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 0;
            }
            int sum = 0;
            // 求出sum的一半
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 == 1) {
                return false;
            }
            int target = sum / 2;
            // 一维背包需要倒序，先i后j
            for(int i = 0; i < nums.length; i++) {
                for(int j = target; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            if (dp[target] == target) {
                return true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}