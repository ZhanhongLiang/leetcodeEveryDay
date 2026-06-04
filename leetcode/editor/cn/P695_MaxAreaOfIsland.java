//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1208 👎 0


package leetcode.editor.cn;

/**
 * 岛屿的最大面积
 * @author DY
 * @date 2026-06-04 16:36:29
 */
public class P695_MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new P695_MaxAreaOfIsland().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            boolean[][] visited = new boolean[m][n];
            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 如果当前位置是陆地，并且没有访问过
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        area = 1;
                        visited[i][j] = true;
                        dfs(grid, visited, i, j);
                        result = Math.max(result,area);
                    }
                }
            }
            return result;
        }
        // 先dfs解决
        int[][] dir = {
                {0, 1}, // 右
                {1, 0}, // 下
                {-1, 0}, // 上
                {0, -1} // 左
        }; // 代表遍历的四个方
        // 记录最大面积
        int area;
        public void dfs(int[][] grid, boolean[][] visited, int x, int y) {
            for(int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0]; // 下一个点
                int nextY = y + dir[i][1];
                // 越界处理
                if (nextX < 0 || nextX >= grid.length ||
                        nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }
                // 当访问到可以的
                if (!visited[nextX][nextY] &&  grid[nextX][nextY] == 1) {
                    area++;
                    visited[nextX][nextY] = true;
                    dfs(grid, visited, nextX, nextY);
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}