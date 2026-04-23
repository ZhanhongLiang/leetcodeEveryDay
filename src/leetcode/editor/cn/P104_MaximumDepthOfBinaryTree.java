//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
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
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2106 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * @author DY
 * @date 2026-04-21 19:02:04
 */
public class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
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
//        public int maxDepth(TreeNode root) {
//            //            List<List<Integer>> result = new ArrayList<>();
//            int ans = 0;
//            if (root == null) {
//                return ans;
//            }
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                List<Integer> level = new ArrayList<>();
//                for (int i = 0; i < size; i++) {
//                    TreeNode current = queue.poll();
//                    if (current.left != null) {
//                        queue.offer(current.left);
//                    }
//                    if (current.right != null) {
//                        queue.offer(current.right);
//                    }
//                }
//                ans++;
//            }
//            return ans;
//        }
//    }

    // 后序遍历
//        private int getDepth(TreeNode root) {
//            if (root == null) return 0; // 递归出口
//            int left = getDepth(root.left); // 左
//            int right = getDepth(root.right); //右
//            return Math.max(left, right) + 1; // 中
//        }
//
//        public int maxDepth(TreeNode root) {
//            if (root == null) return 0;
//            return getDepth(root);
//        }

           // 前序遍历
           int result;

        private void getdepthII(TreeNode node, int depth) {
            result = depth > result ? depth : result;

            if (node.left == null && node.right == null) {
                return;
            }

            if (node.left != null) {
                depth++;
                getdepthII(node.left, depth);
                depth--;
            }

            if (node.right != null) {
                depth++;
                getdepthII(node.right, depth);
                depth--;
            }
        }

        public int maxDepthIII(TreeNode root) {
            result = 0;
            if (root == null) {
                return result;
            }
            getdepthII(root, 1);
            return result;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
}