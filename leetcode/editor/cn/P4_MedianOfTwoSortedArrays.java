//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7867 👎 0


package leetcode.editor.cn;

/**
 * 寻找两个正序数组的中位数
 * @author DY
 * @date 2026-02-16 17:51:09
 */
public class P4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 保证 nums1 是较短数组
            // 从最小长度的数组开始遍历
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int m = nums1.length;
            int n = nums2.length;
            int left = 0;
            int right = m;
            double res = 0.0;
            // 左半部分需要的元素数量
            int totalLeft = (m + n + 1) / 2;
            // 需要先从短的数组开始，i是从0开始
            // 二分法
            while (left <= right){
                // nums1 的切割位置
                int i = left + (right - left) / 2; // mid位置
                // nums2 的切割位置
                int j = totalLeft - i;
                // nums1左边最大数
                int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
                // nums1右边最小值
                int  nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
                // nums2左边最大值
                int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
                // nums2右边最小值
                int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
                if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin){
                    // 偶数
                    if ((m + n) % 2 == 0){
                        return (Math.max(nums1LeftMax, nums2LeftMax)
                                + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                    }else{
                        return Math.max(nums1LeftMax, nums2LeftMax);
                    }
                }else if (nums1LeftMax > nums2RightMin){
                    // 左边数太多
                    right = i - 1;
                }else{
                    // 左边数太少
                    left = i + 1;
                }
            }
            return 0.0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}