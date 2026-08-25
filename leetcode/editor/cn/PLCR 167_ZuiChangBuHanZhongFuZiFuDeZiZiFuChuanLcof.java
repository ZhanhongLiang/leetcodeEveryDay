//某套连招动作记作序列 arr，其中 arr[i] 为第 i 个招式的名字。请返回 arr 中最多可以出连续不重复的多少个招式。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = "dbascDdad"
//输出：6
//解释：因为连续且最长的招式序列是 "dbascD" 或 "bascDd"，所以其长度为 6。
// 
//
// 示例 2： 
//
// 
//输入：arr = "KKK"
//输出：1
//解释：因为无重复字符的最长子串是 "K"，所以其长度为 1。
// 
//
// 示例 3： 
//
// 
//输入：arr = "pwwkew"
//输出：3
//解释：因为连续且最长的招式序列是 "wke"，所以其长度为 3。     
//请注意区分 子串 与 子序列 的概念：你的答案必须是 连续招式 的长度，也就是 子串。而 "pwke" 是一个非连续的 子序列，不是 子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 40000 
// arr 由英文字母、数字、符号和空格组成。 
// 
//
// 
//
// 注意：本题与主站 3 题相同：https://leetcode.cn/problems/longest-substring-without-
//repeating-characters/ 
//
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 635 👎 0


package leetcode.editor.cn;

/**
 * 招式拆解 I
 * @author DY
 * @date 2026-08-21 12:24:21
 */
public class PLCR 167_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 167_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dismantlingAction(String arr) {
            // 这道题就是滑动窗口法
            // 字符窗口
            HashSet<Character> set = new HashSet<>();
            int left = 0, right = 0; // 窗口里面的left指针
            int res = 0; // 答案
            while (right < arr.length()) {
                char c = arr.charAt(right); // 取得窗口最右侧字符
                // 如果没有重复
                if (! set.contains(c)) {
                    set.add(c);
                    res = Math.max(res, right - left + 1);
                    right++;
                }else{
                    set.remove(arr.charAt(left));
                    left++;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}