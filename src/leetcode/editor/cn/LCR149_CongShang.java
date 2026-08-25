//一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从 左 到 右 的顺序返回每一层彩灯编号。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,17,21,18,null,null,6]
//输出：[8,17,21,18,6]
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
 * 彩灯装饰记录 I
 * @author DY
 * @date 2026-08-24 01:09:00
 */
public class LCR149_CongShang {
    public static void main(String[] args) {
        Solution solution = new LCR149_CongShang().new Solution();
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
        public int[] decorateRecord(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            // 典型层序遍历， 用队列即可
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // 答案
            ArrayList<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()){
                // 出队
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}