//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode.cn/problems/minimum-distance-between-bst-nodes/ 相
//同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 661 👎 0


package leetcode.editor.cn;

/**
 * 二叉搜索树的最小绝对差
 * @author DY
 * @date 2026-04-23 21:07:39
 */
public class P530_MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new P530_MinimumAbsoluteDifferenceInBst().new Solution();
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
        int ans = Integer.MAX_VALUE;
        int last;
        boolean isFirst = true; // 是否是第一次遍历
        public int getMinimumDifference(TreeNode root) {
            if (root == null) return 0;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            // 因为是二叉搜索树，所以利用中序遍历的有序性质
            // 左
            dfs(root.left);
            // 中
            if (isFirst) isFirst = false; // 如果是第一次遍历
            else ans = Math.min(ans, Math.abs(last - root.val));
            last = root.val;
            dfs(root.right);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}