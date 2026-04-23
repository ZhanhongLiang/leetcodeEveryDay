//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
// 
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 893 👎 0


package leetcode.editor.cn;

/**
 * 最大二叉树
 * @author DY
 * @date 2026-04-23 12:51:05
 */
public class P654_MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P654_MaximumBinaryTree().new Solution();
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            // 使用单调栈来优化构建过程，使其时间复杂度达到 O(n)
            Deque<TreeNode> stack = new ArrayDeque<>();
            for (int x : nums) {
                TreeNode node = new TreeNode(x);
                // 当当前值大于栈顶值时，栈顶节点应该是当前节点的左孩子
                // 因为在原数组中，栈顶元素在当前元素左侧且比它小
                while (!stack.isEmpty() && stack.peek().val < x) {
                    node.left = stack.pop();
                }
                // 如果栈不为空，说明栈顶元素比当前元素大
                // 那么当前节点应该是栈顶元素的右孩子
                if (!stack.isEmpty()) {
                    stack.peek().right = node;
                }
                // 将当前节点压入栈中，保持栈的单调递减属性
                stack.push(node);
            }
            // 栈底元素即为最大的根节点
            while (stack.size() > 1) {
                stack.pop();
            }

            return stack.peek();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}