//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 树形 DP 👍 2612 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中的最大路径和
 * @author DY
 * @date 2026-08-22 17:37:42
 */
public class P124_BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new P124_BinaryTreeMaximumPathSum().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int sum = Integer.MIN_VALUE; // 最后答案
        public int maxPathSum(TreeNode root) {
            // 后序递归遍历
            if (root == null) return 0;
            dfs(root);
            return sum;
        }

        private int dfs(TreeNode root){
            // 递归出口
            if (root == null) return 0;
            // 左
            // 需要先算出左子树值, 负数需要舍弃
            int left = Math.max(0, dfs(root.left));
            // 右， 负数需要舍弃
            int right = Math.max(0, dfs(root.right));
            // 更新全局最大值
            sum = Math.max(sum, root.val + left + right);
            // 但是返回父节点应该只能left或者right一边，因为路径不能分叉
            return Math.max(left, right) + root.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}