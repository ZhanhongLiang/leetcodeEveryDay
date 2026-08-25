//一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照如下规则记录彩灯装饰结果： 
//
// 
// 第一层按照从左到右的顺序记录 
// 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,17,21,18,null,null,6]
//输出：[[8],[21,17],[18,6]]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 319 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 彩灯装饰记录 III
 * @author DY
 * @date 2026-08-24 01:25:17
 */
public class LCR151_CongShang {
    public static void main(String[] args) {
        Solution solution = new LCR151_CongShang().new Solution();
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
        public List<List<Integer>> decorateRecord(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            boolean leftToRight = true;
            while (!queue.isEmpty()) {
                // 通过控制这个来控制输出
                LinkedList<Integer> cur = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (leftToRight) {
                        cur.addLast(node.val);
                    } else {
                        cur.addFirst(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(cur);
                leftToRight = !leftToRight;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}