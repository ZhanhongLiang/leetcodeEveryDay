//给定一棵二叉树的根节点 root，请左右翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,7,9,8,3,2,4]
//输出：[5,9,7,4,2,3,8]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 注意：本题与主站 226 题相同：https://leetcode.cn/problems/invert-binary-tree/ 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 400 👎 0


package leetcode.editor.cn;

/**
 * 翻转二叉树
 * @author DY
 * @date 2026-08-23 23:29:45
 */
public class LCR144_ErCha {
    public static void main(String[] args) {
        Solution solution = new LCR144_ErCha().new Solution();
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
        public TreeNode flipTree(TreeNode root) {
            if (root == null) return null;
            return dfs(root);
        }

        private TreeNode dfs(TreeNode root){
            if (root == null) return null;
            // 交换左右节点,
            // 根
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            // 左
            dfs(root.left);
            // 右
            dfs(root.right);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}