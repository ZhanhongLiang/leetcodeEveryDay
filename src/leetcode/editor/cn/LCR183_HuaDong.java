//科技馆内有一台虚拟观景望远镜，它可以用来观测特定纬度地区的地形情况。该纬度的海拔数据记于数组 heights ，其中 heights[i] 表示对应位置的海
//拔高度。请找出并返回望远镜视野范围 limit 内，可以观测到的最高海拔值。 
//
// 示例 1： 
//
// 
//输入：heights = [14,2,27,-5,28,13,39], limit = 3
//输出：[27,27,28,28,39]
//解释：
//  滑动窗口的位置                最大值
//---------------               -----
//[14 2 27] -5 28 13 39          27
//14 [2 27 -5] 28 13 39          27
//14 2 [27 -5 28] 13 39          28
//14 2 27 [-5 28 13] 39          28
//14 2 27 -5 [28 13 39]          39 
//
// 
//
// 提示： 
//
// 你可以假设输入总是有效的，在输入数组不为空的情况下： 
//
// 
// 1 <= limit <= heights.length 
// -10000 <= heights[i] <= 10000 
// 
//
// 注意：本题与主站 239 题相同：https://leetcode.cn/problems/sliding-window-maximum/ 
//
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 659 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 望远镜中最高的海拔
 * @author DY
 * @date 2026-08-22 16:06:35
 */
public class LCR183_HuaDong {
    public static void main(String[] args) {
        Solution solution = new LCR183_HuaDong().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxAltitude(int[] heights, int limit) {
            if (heights == null || heights.length == 0 || limit == 0) {
                return new int[0];
            }
            // 双端队列, 并且是存储数组下标，并且一定是从队头到队尾是单调递减的
            // 也就是维持队头是最大的
            Deque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[heights.length - limit + 1]; // 答案数组
            // 只有j - i + 1 == limit,就需要找最大值
            for (int i = 0; i < heights.length; i++) {
                // 当前队头下标是否已经离开窗口
                if (!deque.isEmpty() && deque.peekFirst() < i - limit + 1) {
                    deque.pollFirst();
                }
                // 处理当前heights[i]
                //如果队尾对应的值 `<= heights[i]`，不断删除队尾。
                while (!deque.isEmpty() && heights[deque.peekLast()] <= heights[i]){
                    deque.pollLast();
                }
                // 当前元素入队
                deque.offerLast(i);
                // 窗口形成后，记录最大值
                if (i + 1 >= limit){
                    res[i - limit + 1] = heights[deque.peekFirst()];
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}