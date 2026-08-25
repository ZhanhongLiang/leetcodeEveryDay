//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 3226 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 * @author DY
 * @date 2026-08-19 23:40:43
 */
public class P560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560_SubarraySumEqualsK().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 这道题不能用滑动窗口，因为数组存在负数，也就是整体数组不具备单调性
            // 需要使用前缀和 + HashMap才能解决
            // 用来记录前缀和：次数的哈希map
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1); // 初始化
            int res = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (map.containsKey(sum - k)){
                    res += map.get(sum - k);
                }
                // 再记录当前前缀和
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            // 然后遍历数组
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}