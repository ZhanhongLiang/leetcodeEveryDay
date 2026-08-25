//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2958 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 最长连续序列
 * @author DY
 * @date 2026-08-19 22:08:04
 */
public class P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>(); // 集合，因为连续序列不能是重复数
            // 1. 先将所有数放进set中
            for (int num : nums) {
                set.add(num);
            }
            int res = 0; //结果
            // 找到第一个不存在num-1的数，这个数就是起点
            for (int num : set) {
                if (set.contains(num - 1)) {
                    continue;
                }else{
                    int count = 0;
                    int start = num; //现在num就是起点
                    // 从num 开始加1遍历
                    while(set.contains(start)){
                        count++;
                        start++;
                    }
                    res = Math.max(res,count);
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}