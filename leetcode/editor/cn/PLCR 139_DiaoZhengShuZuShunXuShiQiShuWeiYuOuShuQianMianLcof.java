//教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项
//目编号以 数组 形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：actions = [1,2,3,4,5]
//输出：[1,3,5,2,4] 
//解释：为正确答案之一 
//
// 
//
// 提示： 
//
// 
// 0 <= actions.length <= 50000 
// 0 <= actions[i] <= 10000 
// 
//
// 
//
// Related Topics 数组 双指针 排序 👍 341 👎 0


package leetcode.editor.cn;

/**
 * 训练计划 I
 * @author DY
 * @date 2026-08-21 12:01:55
 */
public class PLCR 139_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 139_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] trainingPlan(int[] actions) {
            int left = 0, right = actions.length - 1;
            while (left < right) {
                while(left < right && actions[left] % 2 == 1) left++;
                while(left < right && actions[right] % 2 == 0) right--;
                // 交换
                int temp = actions[left];
                actions[left] = actions[right];
                actions[right] = temp;
            }
            return actions;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}