//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
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
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 2038 👎 0


package leetcode.editor.cn;

/**
 * 二叉树展开为链表
 * @author DY
 * @date 2026-08-19 15:35:03
 */
public class P114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new P114_FlattenBinaryTreeToLinkedList().new Solution();
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

    /**
     * 从根节点开始不断向右遍历：
     *
     * - 如果当前节点**没有左子树**，直接移动到 `right`。
     * - 如果当前节点**有左子树**：
     *   1. 找到当前节点左子树中的**最右节点**。
     *   2. 将当前节点原来的右子树，接到这个最右节点的 `right` 上。
     *   3. 将当前节点的左子树整体移动到 `right`。
     *   4. 将当前节点的 `left` 置为 `null`。
     * - 然后继续处理当前节点的 `right`。
     *
     * 例如：
     *
     * ```text
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * ```
     *
     * 先把 `1` 的右子树 `5` 接到左子树最右节点 `4` 后面：
     *
     * ```text
     * 1
     *  \
     *   2
     *  / \
     * 3   4
     *      \
     *       5
     *        \
     *         6
     * ```
     *
     * 继续按照相同方式处理 `2`，最终：
     *
     * ```text
     * 1 → 2 → 3 → 4 → 5 → 6
     * ```
     *
     * 这样得到的顺序正好是**先序遍历：根 → 左 → 右**。
     *
     * 时间复杂度 `O(n)`，额外空间复杂度 `O(1)`。
     */
    class Solution {
        public void flatten(TreeNode root) {
            // 维护一个左子树中最右节点，因为每次找到该节点, 就需要将cur节点的右子树接到该最右节点的right
            if (root == null) return;
            TreeNode cur = root; // 当前节点
            TreeNode pre = null; // 左子树中最右节点,该最右节点是一个叶子节点
            while (cur != null) {
                // 先判断当前节点是否有左子树
                if (cur.left == null) {
                    cur = cur.right; // 继续往右边遍历即可
                }else{
                    // 有左子树，得往左子树找到最右节点
                    pre = cur.left;
                    while (pre.right != null){
                        pre = pre.right;
                    }
                    // 找到左子树最右节点
                    pre.right = cur.right; //将右子树移动到该最右节点的右边
                    cur.right = cur.left; // 将cur的right变成左子树
                    cur.left = null; // 将左子树置空即可
                    cur = cur.right;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}