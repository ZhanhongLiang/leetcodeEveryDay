//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 11584 👎 0


package leetcode.editor.cn;

/**
 * 无重复字符的最长子串
 * @author DY
 * @date 2026-08-20 00:26:00
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>(); // 还是滑动窗口
            int res = 0;
            int left = 0, right = 0;
            int valid = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断左侧窗口是否要收缩
                // 当窗口内出现重复数，就要缩小窗口
                while(window.get(c) > 1){
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}