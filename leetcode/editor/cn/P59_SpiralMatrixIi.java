//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1551 👎 0


package leetcode.editor.cn;

/**
 * 螺旋矩阵 II
 * @author DY
 * @date 2026-04-18 15:42:32
 */
public class P59_SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59_SpiralMatrixIi().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int[] dx = {0, 1, 0, -1}; // 设置x的步数方向
            int[] dy = {1, 0, -1, 0}; // 设置y的步数方向
            for (int i = 1, x = 0, y = 0, d = 0; i <= n*n; i++){
                result[x][y] = i;
                int a = x + dx[d];
                int b = y + dy[d];
                if (a < 0 || a >= n || b < 0 || b >= n || result[a][b] != 0) {
                    d = (d + 1) % 4;
                    a = x + dx[d];
                    b = y + dy[d];
                }
                x = a;
                y = b;
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}