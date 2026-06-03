//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 1256 👎 0


package leetcode.editor.cn;

/**
 * 判断子序列
 * @author DY
 * @date 2026-06-03 13:28:08
 */
public class P392_IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new P392_IsSubsequence().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            // dp[i][j]表示以下标i-1为结尾的字符串s和以下标j-1为结尾的字符串t
            // 相同⼦序列的⻓度，所以如果dp[s.size()] [t.size()] 与
            // 字符串s的⻓度相同说明：s与t的最⻓相同⼦序列就是s，那么s 就是 t
            // 的⼦序列。 当text1[i -1] == text2[j - 1]
            // 也就是以i-1为结尾的A等于以j-1为结尾的B
            // 则dp[i][j]是由上一个状态i-1和j-1推导出来
            // 否则dp[i][j]是由左边和上边推导出来
            // if (t.size() == 0 || s.size() == 0) {
            //     return false;
            // }
//            if (s.isEmpty() &&  t.isEmpty()) return true;
//            if (s.isEmpty()) return false;
            // dp[i][j] 代表第[0,i-1]的S的最长子序列，那么就需要固定s，从t开始匹配
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            Arrays.fill(dp[0], 0);
            boolean res = false;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
            if (dp[s.length()][t.length()] == s.length())  return true;
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}