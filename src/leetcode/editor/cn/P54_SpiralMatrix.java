//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 2118 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * @author DY
 * @date 2026-04-18 16:56:19
 */
public class P54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54_SpiralMatrix().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return res;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] st = new boolean[m][n];
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            for (int i = 0, x = 0, y = 0, d = 0; i < m * n; i++) {
                res.add(matrix[x][y]);
                st[x][y] = true;

                int a = x + dx[d];
                int b = y + dy[d];

                if (a < 0 || a >= m || b < 0 || b >= n || st[a][b]) {
                    d = (d + 1) % 4;
                    a = x + dx[d];
                    b = y + dy[d];
                }
                x = a;
                y = b;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}