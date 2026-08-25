//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 3048 👎 0


package leetcode.editor.cn;

/**
 * 数组中的第K个最大元素
 * @author DY
 * @date 2026-08-13 14:11:39
 */
public class P215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 第k大的元素对应升序数组下标 n-k
            int target = nums.length - k;

            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int index = partition(nums, low, high);
                if (index == target){
                    return nums[index];
                }else if (index < target){
                    // 从右边找
                    low = index + 1;
                }else{
                    high = index - 1;
                }
            }
            return -1;
        }
        // 快排选择分区变体
        private int partition(int[] nums, int low, int high) {
            // 随机选择pivot位置
            int randomIndex = low + (int)(Math.random() * (high - low + 1));
            // 将随机pivot放到最左边
            swap(nums, low, randomIndex);

            int i,j, pivot;
            i = low;
            j = high;
            pivot = nums[low];
            while (i < j) {
                // 从右往左找到第一个小于pivot的数
                while(i < j && nums[j] >= pivot) j--;
                if(i < j) nums[i++] =  nums[j];
                // 从左往右找到第一个大于pivot的数
                while(i < j && nums[i] <= pivot) i++;
                if(i < j) nums[j--] =  nums[i];
            }
            // 归位
            nums[i] =  pivot;
            return i;
        }
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}