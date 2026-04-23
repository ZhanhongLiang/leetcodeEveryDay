//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2418 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * @author DY
 * @date 2026-04-20 16:43:23
 */
public class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
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
//        public List<Integer> inorderTraversal(TreeNode root) {
//            // 递归法后序遍历
//            // 左 中 右
//            List<Integer> res = new ArrayList<>();
//            if (root == null) return res;
//            traverse(root, res);
//            return res;
//        }
//
//        private void traverse(TreeNode root, List<Integer> res) {
//            if (root == null) return;
//            traverse(root.left, res); // 左
//            res.add(root.val); //中
//            traverse(root.right, res); // 右
//        }
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode cur = stack.peek(); // 顶部的树节点
                if (cur != null){
                    stack.pop(); // 退栈
                    if (cur.right != null) {
                        stack.push(cur.right);
                    }
                    stack.push(cur); // 压栈
                    stack.push(null); // 压入null作为标记
                    if (cur.left != null) {
                        stack.push(cur.left);
                    }
                }else {
                    stack.pop();
                    TreeNode temp = stack.pop();
                    result.add(temp.val);
                }
            }
            return result;
        }
    }


    //leetcode submit region end(Prohibit modification and deletion)
}