//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2733 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * @author DY
 * @date 2026-04-23 11:45:13
 */
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        // 这里面涉及到快速找到中序遍历的根节点位置, 然后分出区间
        Map<Integer,Integer> pos = new HashMap<>(); // 用来记录中序遍历
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for(int i = 0; i < inorder.length; i++) pos.put(inorder[i],i); //中序遍历中inorder对应i位置, 方便后续直接查询,实现O(1)复杂度
            return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        }
        private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
            // 当preleft > preRight 退出递归
            if (preLeft > preRight || inLeft > inRight) return null;
            // 前序遍历的第一个节点即为当前子树的根节点
            TreeNode root = new TreeNode(preorder[preLeft]);
            int k =  pos.get(root.val); // 找到根节点在中序遍历的位置, 然后直接
            // 计算左子树的长度：中序遍历中根节点位置减去左边界
//            int leftSize = k - inLeft; // 算出左子树节点长度
            // 递归构建左子树
            // 前序：[pl + 1, pl + 1 + k -1 - il]
            // 中序：[il, k - 1]
            root.left = build(preorder, inorder, preLeft + 1, preLeft + 1 + k - 1 - inLeft, inLeft, k - 1);

            // 递归构建右子树
            // 前序：[pl + leftSize + 1, pr]
            // 中序：[k + 1, ir]
            root.right = build(preorder, inorder, preLeft + 1 + k - 1 - inLeft + 1, preRight, k + 1, inRight);
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}