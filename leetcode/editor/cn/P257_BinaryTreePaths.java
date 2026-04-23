//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1295 👎 0


package leetcode.editor.cn;

/**
 * 二叉树的所有路径
 * @author DY
 * @date 2026-04-22 18:24:45
 */
public class P257_BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257_BinaryTreePaths().new Solution();
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
        List<String> ans = new ArrayList<>(); // 记录路径综合
        List<Integer> path = new ArrayList<>(); // 记录走过的路径
        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode root) {
            path.add(root.val);
            // 如果当前是叶子节点
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(path.get(0));
                for (int i = 1; i < path.size(); i++) {
                    sb.append("->").append(path.get(i));
                }
                ans.add(sb.toString());
            }else {
                if (root.left != null) dfs(root.left);
                if (root.right != null) dfs(root.right);
            }
            // 回溯：移除路径中最后一个节点
            path.remove(path.size() - 1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}