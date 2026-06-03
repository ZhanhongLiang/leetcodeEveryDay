//给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。 
//
// 测试用例保证结果在 32 位有符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1426 👎 0


package leetcode.editor.cn;

/**
 * 不同的子序列
 * @author DY
 * @date 2026-06-03 13:44:58
 */
public class P115_DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new P115_DistinctSubsequences().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            // 返回s中出现划分t的的情况数
            // dp[i][j]是 以i-1为结尾的s子序列中出现j-1为结尾的t的个数为dp[i][j]
            // 当s[i - 1] == t[i - 1]的时候
            // dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            // 否则dp[i][j] = dp[i - 1][j]
            // 这个我只能画图自己理解一遍,难以理解
            // 为什么当以i-1，j-1为结尾不相等的时候,需要dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j <= t.length(); j++) {
                dp[0][j] = 0;
            }
            dp[0][0] = 0;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[s.length()][t.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}