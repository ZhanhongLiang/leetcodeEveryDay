//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 1246 👎 0


package leetcode.editor.cn;

/**
 * 最长重复子数组
 * @author DY
 * @date 2026-06-03 11:51:53
 */
public class P718_MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new P718_MaximumLengthOfRepeatedSubarray().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            // 这里涉及两个数组, 需要二维度dp, 且这个是最长的连续子序列
            if (nums1.length < 1 || nums2.length < 1) return 0;
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int res = 0; // 保存结果
            Arrays.fill(dp[0], 0); // 如果全部都要填1
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}