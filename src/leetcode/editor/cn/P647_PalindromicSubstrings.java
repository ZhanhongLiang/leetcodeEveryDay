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
 * @date 2026-06-03 15:06:44
 */
public class P647_PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new P647_PalindromicSubstrings().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            // vector<vector<bool>> dp(s.size() + 1, vector<bool>(2,false));
            // dp[i][j] 代表[i,j]区间的字符串是否是回文字符串
            // false代表不是回文字符串,true代表是回文字符串
            // 递推公式:
            //        如果s[i] == s[j]
            //            1.如果j==i,那么肯定是回文字串,dp[i][j] = true;
            //            2.如果j-i == 1,那么也肯定是回文字串,例如aa,dp[i][j]=true;
            //            3.如果j-i > 1,那么需要判断dp[i + 1][j-1]是否是回文字串
            // 因为需要判断i+1和j-1, 且,dp[i][j]是由左下角推导上来的,
            // 也就是遍历顺序必须是从下到上，从左到右
            int res = 0; // 记录回文字符串数量
            boolean[][] dp = new boolean[s.length()][s.length()];
            //初始化
            for(int i = s.length() - 1; i >= 0; i--){
                for(int j = i; j < s.length(); j++){
                    if (s.charAt(i) == s.charAt(j)){
                        if (j - i <= 1){
                            // 也就是当j 和 i 索引值只差1的时候，或者相等时候
                            dp[i][j] = true;
                            res++;
                        } else if (dp[i+1][j-1]) {
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