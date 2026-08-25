//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层（从第 0 层开始），则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1325 👎 0


package leetcode.editor.cn;

/**
 * 完全二叉树的节点个数
 * @author DY
 * @date 2026-08-23 12:32:15
 */
public class P222_CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new P222_CountCompleteTreeNodes().new Solution();
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
        private int count = 0; // 节点数量
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return dfs2(root);
//            return dfs(root);
        }

        private int dfs(TreeNode root){
            // 后序遍历
            if(root == null) return 0;
            int countLeft = dfs(root.left);
            int countRight = dfs(root.right);
            return 1 + countLeft + countRight;
        }

        private int dfs2(TreeNode root){
            // 前序遍历
            // 但是这次需要利用上高度, 就是每次返回给父节点的是高度才对
            // 不是返回节点数，这样就可以控制时间复杂度是O(n)
            if(root == null) return 0;
            // 根
            // 算左子树的高度、算右子树的高度
            int leftHeight = getLeftHeight(root);
            int rightHeight = getRightHeight(root);
            // 判断当前节点的左子树的高度是否和右子树一致
            // 需要根据完全二叉树性质，如果左右子树高度不一致，那么必然是左子树满叉二叉树
            // 右子树是非满叉
            if (leftHeight == rightHeight){
                // 左子树是满二叉树
                // 2 ^ h - 1
                return (1 << leftHeight) - 1;
            }
            return 1 +  dfs2(root.left) + dfs2(root.right);
        }

        private int getLeftHeight(TreeNode root){
            int height = 0;
            while (root != null){
                height++;
                root = root.left;
            }
            return height;
        }

        private int getRightHeight(TreeNode root){
            int height = 0;
            while (root != null){
                height++;
                root = root.right;
            }
            return height;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}