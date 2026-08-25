//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 2915 👎 0


package leetcode.editor.cn;

/**
 * 下一个排列
 * @author DY
 * @date 2026-08-12 14:32:25
 */
public class P31_NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31_NextPermutation().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            // 寻找字典序下一个紧挨者的序列, 也就是[1,2,3] - [1,3,2] - [2, 1, 3] - [2, 3, 1] - [3, 1, 2] - [3, 2, 1]
            // 从右往左遍历, 找到第一个非降序的数, 也就是第一个前面的数比后面的数大的数,这个前面的数是与后面的数连续近邻的
            int n = nums.length;
            if (n == 1) return;
            int target = -1;
            for(int i = n - 1; i > 0; i--){
                // 只需要从后到前面俩俩比较即可
                if(nums[i] >  nums[i-1]){
                    // 找到第一个要交换的位置
                    // 记录该位置
                    target = i - 1;
                    break;
                }
            }
            // 如果target位置还是-1, 则没有合适位置, 也就是说是降序序列, 直接变升序序列
            if(target == -1){
                reverse(nums, 0, n - 1);
                return;
            }
            // 找到第一个刚大于该位置的一个数, 也就是需要从target位置往后遍历，恰好大一点的数
            // 因为i-1位置右边整个序列恰好是严格降序的，所以只需要从右往左重新遍历一遍，找到的第一个大于i-1位置的数就是恰好的
            for(int i = n - 1; i > target; i--){
                if(nums[i] > nums[target]){
                    // 交换即可
                    int temp =  nums[i];
                    nums[i] = nums[target];
                    nums[target] = temp;
                    break;
                }
            }
            // 直接将i-1位置后的序列变成升序序列即可
            reverse(nums, target + 1, n - 1);
        }

        private static void reverse(int[] arr, int start, int end) {
            int left = start;
            int right = end;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}