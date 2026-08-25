//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符，再重新计数。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 726 👎 0


package leetcode.editor.cn;

/**
 * 反转字符串 II
 * @author DY
 * @date 2026-08-19 16:13:21
 */
public class P541_ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new P541_ReverseStringIi().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            // 以2k为一组, 遍历到当前组的k位置，就采用双指针法反转即可
            char[] chars = s.toCharArray(); // 把字符串转为字符数组
            for(int i = 0; i < chars.length; i+= 2*k){
                // 双指针法
                int left = i;
                int right = Math.min(i+k-1, chars.length-1);
                while(left < right){
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
            }
            return String.valueOf(chars);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}