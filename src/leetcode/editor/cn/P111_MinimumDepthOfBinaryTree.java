//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1341 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * @author DY
 * @date 2026-04-21 19:17:49
 */
public class P111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
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
//        public int minDepth(TreeNode root) {
//            if (root == null) return 0;
//            // 如果是叶子节点，返回1
//            if (root.left == null && root.right == null) return 1;
//            // 如果左右中
//            int  left = minDepth(root.left);
//            int right = minDepth(root.right);
//            if (root.left == null || root.right == null) return left + right + 1;
//            return Math.min(left, right) + 1;
//        }
        public int minDepth(TreeNode root) {
            //            List<List<Integer>> result = new ArrayList<>();
            int ans = 0;
            if (root == null) {
                return ans;
            }
            int depth = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ans++;
                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    if (current.left == null && current.right == null) {
                        return ans;
                    }
                }
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}