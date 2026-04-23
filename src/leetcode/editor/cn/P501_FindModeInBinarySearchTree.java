//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 833 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的众数
 * @author DY
 * @date 2026-04-23 21:15:26
 */
public class P501_FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501_FindModeInBinarySearchTree().new Solution();
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
        // 进阶解法，徐娅走空间O(1)的解法, 所以不能额外引入哈希表
        int maxCount = Integer.MIN_VALUE;
        int curCount = 0; // 当前遍历的节点出现次数
        List<Integer> ans = new ArrayList<>();
        int pre; // 上一个出现的数
        public int[] findMode(TreeNode root) {
            dfs(root);
            // 将 List 转换为题目要求的 int[] 格式
            int[] result = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                result[i] = ans.get(i);
            }
            return result;
        }
        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            // 中, 当第一次统计，或者前一个数等于当前的数，就需要统计当前
            if (curCount == 0 || pre == root.val ) {
                curCount++;
                pre = root.val;
            }else {
                pre = root.val;
                curCount = 1;
            }
            if (curCount > maxCount){
                maxCount = curCount;
                ans.clear(); // 清楚之前的
                ans.add(pre);
            }else if (curCount == maxCount){
                ans.add(pre);
            }
            dfs(root.right);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}