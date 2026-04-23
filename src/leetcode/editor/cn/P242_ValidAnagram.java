//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 1103 👎 0


package leetcode.editor.cn;

/**
 * 有效的字母异位词
 * @author DY
 * @date 2026-04-19 19:14:27
 */
public class P242_ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242_ValidAnagram().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] hash = new int[26];
            for (char c : s.toCharArray()){
                hash[c - 'a']++;
            }
            for (char c : t.toCharArray()){
                if (--hash[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}