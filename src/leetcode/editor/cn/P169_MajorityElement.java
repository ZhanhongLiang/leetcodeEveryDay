//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 输入保证数组中一定有一个多数元素。 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 摩尔投票算法 👍 2721 👎 0


package leetcode.editor.cn;

/**
 * 多数元素
 * @author DY
 * @date 2026-08-19 18:14:31
 */
public class P169_MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169_MajorityElement().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 哈希表经典题目, 但是用哈希表，无法实现空间复杂度为O(1)
            // 所以采用摩尔投票法
            // 维护两个变量, 一个是candidate：当前候选的多数元素
            //count`：当前候选元素的票数。
            int candidate = nums[0];
            int count = 0;
            // 遍历数组,当count=0的时候，当前数为candidate
            for(int i = 0; i < nums.length; i++){
                if(count == 0){
                    candidate = nums[i];
                }
                if(candidate == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
            return candidate;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}