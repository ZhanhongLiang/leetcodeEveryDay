//给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。 注意，空树 不会是以 
//tree1 的某个节点为根的子树具有 相同的结构和节点值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//
// 
//输入：tree1 = [1,7,5], tree2 = [6,1]
//输出：false
//解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
//输出：true
//解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。 
//
// 
//
// 提示： 
//
// 0 <= 节点个数 <= 10000 
//
// Related Topics 树 深度优先搜索 二叉树 👍 848 👎 0


package leetcode.editor.cn;

/**
 * 子结构判断
 * @author DY
 * @date 2026-08-23 21:52:22
 */
public class LCR143_ShuDe {
    public static void main(String[] args) {
        Solution solution = new LCR143_ShuDe().new Solution();
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // 题目规定空树不是子结构
            if (A == null || B == null) {
                return false;
            }
            return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean isSame(TreeNode tree1, TreeNode tree2){
            // 先序遍历
            // 如果tree2先提前遍历好, 那么就结构对称
            if (tree2 == null){
                return true;
            }
            if (tree1 == null){
                return false;
            }
            // 根节点
            if (tree1.val != tree2.val){
                return false;
            }
            return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}