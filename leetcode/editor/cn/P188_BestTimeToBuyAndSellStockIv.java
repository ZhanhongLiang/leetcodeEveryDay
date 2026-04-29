//给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1359 👎 0


package leetcode.editor.cn;

/**
 * 买卖股票的最佳时机 IV
 * @author DY
 * @date 2026-04-29 22:33:24
 */
public class P188_BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new P188_BestTimeToBuyAndSellStockIv().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int[][] dp = new int[prices.length][2 * k + 1];// 有k次交易，则有2 * k个状态
            for (int i = 1; i < 2 * k; i++){
                // 如果是偶数，则未-price[0]
                if (i % 2 == 0){
                    dp[0][i] = 0;
                }else{
                    dp[0][i] = -prices[0];
                }
            }
            for (int i = 1; i < prices.length; i++) {
                for (int j = 0; j < 2 * k - 1; j += 2) {
                    dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                    dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
                }
            }
            return dp[prices.length - 1][2 * k];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}