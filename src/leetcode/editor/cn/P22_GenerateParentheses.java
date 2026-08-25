//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 括号序列 👍 4136 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author DY
 * @date 2026-08-24 16:33:12
 */
/**
 * void backtracking(参数) {
    if (终⽌条件) {
    存放结果;
    return;
    }
    for (选择：本层集合中元素（树中节点孩⼦的数量就是集合的⼤⼩）) {
    处理节点;
    backtracking(路径，选择列表); // 递归
    回溯，撤销处理结果
    }
 }
 */
public class P22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 全局结果集
        private List<String> res = new ArrayList<>();

        // 全局路径
        private StringBuilder path = new StringBuilder();

        public List<String> generateParenthesis(int n) {
            if (n == 0) return res;
            backtrack(0,0,n);
            return res;
        }

        // 经典回溯算法题目
        private void backtrack(int left, int right, int n){
            // 递归出口
            if (left == n && right == n){
                res.add(path.toString());
                return;
            }
            // 添加左括号
            if (left < n){
                path.append("(");
                // 因为left+1是局部的, 也就是天然具有回溯效果
                backtrack(left + 1, right, n);
                // 回溯
                path.deleteCharAt(path.length() - 1);
            }
            // 前缀组合具有天然的右括号数量 < 左括号
            // 添加右括号
            if (right < left){
                path.append(')');
                // 因为right+1是局部的, 也就是天然具有回溯效果
                backtrack(left, right + 1, n);
                // 回溯
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}