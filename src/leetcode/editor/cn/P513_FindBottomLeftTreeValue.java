//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 658 👎 0


package leetcode.editor.cn;

/**
 * 找树左下角的值
 * @author DY
 * @date 2026-04-22 22:14:13
 */
public class P513_FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new P513_FindBottomLeftTreeValue().new Solution();
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
        int ans, maxDepth = 0;
        public int findBottomLeftValue(TreeNode root) {
            dfs(root, 1);
            return ans;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) return;
            // 如果递归传入的depth > maxDepth, 则找到最左侧值
            if (depth > maxDepth){
                maxDepth = depth;
                ans = node.val;
            }
            dfs(node.left, depth+1);
            dfs(node.right, depth+1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}