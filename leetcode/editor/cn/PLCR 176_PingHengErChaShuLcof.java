//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true 
//解释：如下图
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//解释：如下图
// 
//
// 
// 
//
// 提示： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode.cn/problems/balanced-binary-tree/ 
//
// Related Topics 树 深度优先搜索 二叉树 👍 406 👎 0


package leetcode.editor.cn;

/**
 * 判断是否为平衡二叉树
 * @author DY
 * @date 2026-08-24 15:46:53
 */
public class PLCR 176_PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 176_PingHengErChaShuLcof().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return dfs(root) == -1 ? false : true;
        }

        // 返回以当前子树为根的高度，如果子树不平衡，则返回特殊值
        private int dfs(TreeNode root) {
            if (root == null) return 0;
            // 后序遍历
            // 左
            int leftHeight = dfs(root.left);
            // 右
            int rightHeight = dfs(root.right);
            // 根
            if (leftHeight == -1 || rightHeight == -1) return -1;
            if (Math.abs(leftHeight - rightHeight) > 1) return -1; //当前节点为根的左右子树高度差值大于1，则代表以该节点是非平衡子树

            return Math.max(leftHeight, rightHeight) + 1; // 如果该以该节点为根节点是平衡子树，则返回树高+1
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)
}