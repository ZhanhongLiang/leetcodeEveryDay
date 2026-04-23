//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。 
//
// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果： 
//
// 
// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。 
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到
//下一棵树，并继续采摘。 
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。 
// 
//
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：fruits = [1,2,1]
//输出：3
//解释：可以采摘全部 3 棵树。
// 
//
// 示例 2： 
//
// 
//输入：fruits = [0,1,2,2]
//输出：3
//解释：可以采摘 [1,2,2] 这三棵树。
//如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
// 
//
// 示例 3： 
//
// 
//输入：fruits = [1,2,3,2,2]
//输出：4
//解释：可以采摘 [2,3,2,2] 这四棵树。
//如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
// 
//
// 示例 4： 
//
// 
//输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：可以采摘 [1,2,1,1,2] 这五棵树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= fruits.length <= 10⁵ 
// 0 <= fruits[i] < fruits.length 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 848 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 水果成篮
 * @author DY
 * @date 2026-04-18 10:43:25
 */
public class P904_FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new P904_FruitIntoBaskets().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            int result = 0;
            // 用来记录整个数组的水果种类
            HashMap<Integer, Integer> types = new HashMap<>();
            for (int left = 0, winTypes = 0, right = 0; right < fruits.length; right++) {
                // 需要判断当前水果种类是否在哈希表中
                types.put(fruits[right], types.getOrDefault(fruits[right], 0) + 1);
                if(types.get(fruits[right])==1){ // 如果当前窗口的水果种类为1, 则win_types++
                    winTypes++;
                }
                while(winTypes > 2){
                    // 需要窗口缩短进行试探
                    types.put(fruits[left],types.get(fruits[left]) - 1);
                    if (types.get(fruits[left]) == 0) {
                        winTypes--;
                    }
                    left++;
                }
                result = Math.max(result, right - left + 1);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}