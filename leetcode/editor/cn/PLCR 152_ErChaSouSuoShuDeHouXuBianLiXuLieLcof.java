//请实现一个函数来判断整数数组 postorder 是否为二叉搜索树的后序遍历结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: postorder = [4,9,6,5,8]
//输出: false 
//解释：从上图可以看出这不是一颗二叉搜索树
// 
//
// 示例 2： 
//
// 
//
// 
//输入: postorder = [4,6,5,9,8]
//输出: true 
//解释：可构建的二叉搜索树如上图
// 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// postorder 中无重复数字 
// 
//
// 
//
// Related Topics 栈 树 二叉搜索树 递归 数组 二叉树 单调栈 👍 793 👎 0


package leetcode.editor.cn;

/**
 * 验证二叉搜索树的后序遍历序列
 * @author DY
 * @date 2026-08-24 09:34:45
 */
public class PLCR 152_ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 152_ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyTreeOrder(int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return true;
            }

            return dfs(postorder, 0, postorder.length - 1);
        }

        private boolean dfs(int[] postorder, int left, int right){
            // 递归出口
            if (left >= right){
                return true;
            }
            // right 肯定为 根节点
            int root =  postorder[right];
            // 寻找第一个大于root的数
            int index = left; // 划分index
            // 找出第一个大于root的数
            while (index < right && postorder[index] < root) {
                // 这里潜在就是[left, index - 1]都是小于 root
                index++;
            }
            // index之后应该全部属于右子树，并且都大于root
            for (int i = index; i < right; i++) {
                if (postorder[i] < root) {
                    return false;
                }
            }
            // 左子树 + 右子树递归判断
            return dfs(postorder, left, index - 1)
                    && dfs(postorder, index, right - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}