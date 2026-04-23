//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1402 👎 0


package leetcode.editor.cn;

/**
 * 从中序与后序遍历序列构造二叉树
 * @author DY
 * @date 2026-04-23 12:11:34
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for(int i=0;i<inorder.length;i++) pos.put(inorder[i],i);
            return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        }

        private TreeNode build(int[] inorder, int[] postorder,int inLeft, int inRight, int postLeft, int postRight) {
            if(inLeft>inRight || postLeft>postRight) return null;
            TreeNode root = new TreeNode(postorder[postRight]); // 后序遍历最后一个是根节点
            int k = pos.get(root.val); // 找到k位置
            root.left = build(inorder,postorder,inLeft,k-1,postLeft,postLeft + k - 1 - inLeft);
            root.right = build(inorder,postorder, k + 1, inRight,postLeft + k - 1 - inLeft + 1, postRight - 1);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}