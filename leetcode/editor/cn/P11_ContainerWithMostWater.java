//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 6031 👎 0


package leetcode.editor.cn;

/**
 * 盛最多水的容器
 * @author DY
 * @date 2026-08-12 16:25:09
 */
public class P11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11_ContainerWithMostWater().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            // 双指针法
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                int area = Math.min(height[left], height[right]) * (right - left);
                if (area > maxArea) {
                    maxArea = area;
                }
                // 需要移动指针
                // 如果height[left]高度较小, 则需要寻找更高的, 向右移动
                if (height[left] < height[right]) {
                    left++;
                }else {
                    right--;
                }
            }
            return maxArea;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}