//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 测试用例保证输出的长度不会超过 10⁵。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 2265 👎 0


package leetcode.editor.cn;

/**
 * 字符串解码
 * @author DY
 * @date 2026-08-20 11:14:45
 */
public class P394_DecodeString {
    public static void main(String[] args) {
        Solution solution = new P394_DecodeString().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public String decodeString(String s) {
            // 记录次数栈
            Deque<Integer> numStack = new ArrayDeque<>();
            // 记录字符串栈
            Deque<String> stStack = new ArrayDeque<>();
            // 当前的字符串
            StringBuilder current = new StringBuilder();
            // 次数
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 判断当前字符是否是数字
                if (Character.isDigit(c)) {
                    // 需要将当前字符转为数字
                    // 因为存在多位数的情况, 也就是必须使用这类转换方法
                    // 12 - > 0 *10 + (1-'0') = 1 -> 1*10 + (2 - '0') = 12
                    num = num * 10 + (c - '0');
                }else  if (c == '[') {
                    // 将当前num压入栈
                    numStack.push(num);
                    stStack.push(current.toString());
                    // 清空current
                    current  = new StringBuilder();
                    num = 0;
                } else if (c == ']') {
                    int repeat = numStack.pop();
                    // 取出上一层字符串
                    StringBuilder tempBuilder = new StringBuilder(stStack.pop());
                    // 当前字符串重复 repeat 次
                    for (int j = 0; j < repeat; j++) {
                        tempBuilder.append(current);
                    }
                    // 拼接后的结果作为当前层结果
                    current = tempBuilder;
                } else{
                    current.append(c);
                }
            }
            return current.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}