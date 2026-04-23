//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，
//返回空字符串 ""。 
//
// 测试用例保证答案唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//O(m + n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3573 👎 0


package leetcode.editor.cn;

/**
 * 最小覆盖子串
 * @author DY
 * @date 2026-04-18 11:12:58
 */
public class P76_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] tCharCount = new int[128]; // 用来记录t字符串维护种类
            int[] winCharCount = new int[128]; // 用来记录窗口内的每个字符的种类
            // 用tCharCount[c]记录
            for (char c : t.toCharArray()){
                tCharCount[c]++;
            }
            String result = "";
            for (int right = 0, left = 0, count = 0; right < s.length(); right++) {
                // 记录winCharCount里面窗口存在的字符
                char rightChar = s.charAt(right);
                winCharCount[rightChar]++;
                if (winCharCount[rightChar] <= tCharCount[rightChar]) {
                    count++;
                }
                // 当窗口中left指针的字符数量大于t中该字符数量，就需要缩小窗口了
                while (left <= right && winCharCount[s.charAt(left)] > tCharCount[s.charAt(left)]){
                    winCharCount[s.charAt(left)]--;
                    left++;
                }
                if (count == t.length()) {
                    if (result.isEmpty() || result.length() > right - left + 1) {
                        result = s.substring(left, right + 1);
                    }
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}