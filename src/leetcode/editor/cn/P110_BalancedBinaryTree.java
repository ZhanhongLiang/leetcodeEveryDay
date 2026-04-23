//给定一个二叉树，判断它是否是 平衡二叉树 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1707 👎 0


package leetcode.editor.cn;

/**
 * 平衡二叉树
 * @author DY
 * @date 2026-04-21 21:26:57
 */
public class P110_BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110_BalancedBinaryTree().new Solution();
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
        boolean isBalanced = true;
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            dfs(root);
            return isBalanced;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            // 左右中
            if (Math.abs(left - right) > 1) isBalanced = false;
            return Math.max(left, right) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}