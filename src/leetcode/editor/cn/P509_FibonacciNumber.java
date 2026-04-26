//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化 数学 动态规划 👍 901 👎 0


package leetcode.editor.cn;

/**
 * 斐波那契数
 * @author DY
 * @date 2026-04-25 16:10:40
 */
public class P509_FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new P509_FibonacciNumber().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            // 当 n 为 0 或 1 时，直接返回结果
            if (n <= 1) {
                return n;
            }

            // dp[i] 的含义是第 i 个斐波那契数
            int[] dp = new int[n + 1];

            // 初始化基础状态
            dp[0] = 0;
            dp[1] = 1;

            // 状态转移方程：dp[i] = dp[i - 1] + dp[i - 2]
            // 遍历顺序：从前向后
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}