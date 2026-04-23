//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 8021 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author DY
 * @date 2026-04-20 08:46:28
 */
public class P15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15_ThreeSum().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 固定i, 然后利用j,k进行双指针
            // 容易证明得，设nums[i] 为c, 则nums[j] + nums[k] + c
            // j 递增， k为递减
            // 则 nums[j] + nums[k] + c > 0 -> k--
            //  nums[j] + nums[k] + c < 0   -> j++
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                // 如果nums[i] > 0， 其实可以直接跳出，因为后面都是递增
                if (nums[i] > 0) {
                    return ans;
                }
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int c = nums[i];
                int j = i + 1,  k = nums.length - 1;
                while (j < k) {
                    // 使用双指针
                    if (nums[j] + nums[k] + c > 0) {
                        k--;
                    }else if (nums[j] + nums[k] + c < 0) {
                        j++;
                    }else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        // 但是后续还需要去重
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}