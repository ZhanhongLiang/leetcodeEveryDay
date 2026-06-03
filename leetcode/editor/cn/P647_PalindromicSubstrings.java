//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 1520 👎 0


package leetcode.editor.cn;

/**
 * 回文子串
 * @author DY
 * @date 2026-06-03 15:06:50
 */
public class P647_PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new P647_PalindromicSubstrings().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();

            // dp[i][j] 表示 s[i...j] 是否是回文子串
            boolean[][] dp = new boolean[n][n];

            int res = 0;

            // 因为 dp[i][j] 依赖 dp[i + 1][j - 1]
            // 所以 i 要从后往前遍历
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {

                    if (s.charAt(i) == s.charAt(j)) {

                        // 情况一：一个字符，例如 "a"
                        // 情况二：两个字符，例如 "aa"
                        if (j - i <= 1) {
                            dp[i][j] = true;
                            res++;
                        }
                        // 情况三：长度大于 2，需要看中间部分是不是回文
                        else if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}