//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2348 👎 0


package leetcode.editor.cn;

/**
 * 路径总和 III
 * @author DY
 * @date 2026-08-23 10:48:04
 */
public class P437_PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437_PathSumIii().new Solution();
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
        private long currentSum = 0L; // 记录当前路径和为多少
        // 记录当前路径上出现过的前缀和次数。
        private HashMap<Long, Integer> map = new HashMap<>();
        private int count = 0; // 统计出现有多少跳路径

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            map.put(0L, 1); // 0 也算
            dfs(root, targetSum);
            return count;
        }

        // 前序遍历
        private void dfs(TreeNode root, int targetSum) {
            if (root == null) return;
            // 根节点
            currentSum += root.val;
            // 查询 currentSum - targetSum是否存在于Map中, 这个就是前缀和的思路
            if (map.containsKey(currentSum -  targetSum)) {
                count +=  map.get(currentSum -  targetSum); //
            }
            // 当前前缀和加入map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
            // 回溯
            map.put(currentSum, map.get(currentSum) - 1);
            currentSum -= root.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}