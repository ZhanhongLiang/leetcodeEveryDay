//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
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
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2087 👎 0


package leetcode.editor.cn;

/**
 * 翻转二叉树
 * @author DY
 * @date 2026-04-22 07:51:03
 */
public class P226_InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P226_InvertBinaryTree().new Solution();
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
        public TreeNode invertTree(TreeNode root) {
            // 递归出口：如果节点为空，直接返回 null
            if (root == null) {
                return null;
            }


            // 递归处理左子树
            invertTree(root.left);
            // 递归处理右子树
            invertTree(root.right);
            // 先中：交换当前节点的左右孩子
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}