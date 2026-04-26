//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1545 👎 0


package leetcode.editor.cn;

/**
 * 整数拆分
 * @author DY
 * @date 2026-04-25 22:23:46
 */
public class P343_IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new P343_IntegerBreak().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 2];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i],Math.max(j * dp[i - j], j * (i - j)));
                }
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}