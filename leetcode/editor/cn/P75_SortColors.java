//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 冒泡排序 排序 快速排序 👍 2112 👎 0


package leetcode.editor.cn;

/**
 * 颜色分类
 * @author DY
 * @date 2026-08-13 00:31:34
 */
public class P75_SortColors {
    public static void main(String[] args) {
        Solution solution = new P75_SortColors().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            if (nums.length == 1) return;
            // 三指针法
            int left = 0;
            int cur = 0;
            int right = nums.length - 1;
            while (cur <= right) {
                // left需要指向下一个放0的位置
                // cur当前遍历位置
                // right 指向下一个放2的位置
                // 判断当前位置cur的数
                if (nums[cur] == 0){
                    // 交换到left位置，维护一个left区间
                    swap(nums,cur,left);
                    left++;
                    cur++;
                }else if(nums[cur] == 1){
                    cur++;
                }else{
                    swap(nums,cur,right);
                    right--;
                }
            }
        }
        private void swap(int nums[], int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}