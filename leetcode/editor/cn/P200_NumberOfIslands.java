//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2997 👎 0


package leetcode.editor.cn;

/**
 * 岛屿数量
 * @author DY
 * @date 2026-06-03 16:50:42
 */
public class P200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200_NumberOfIslands().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            boolean[][] visited = new boolean[m][n];
            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 如果当前位置是陆地，并且没有访问过
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        result++;
                        visited[i][j] = true;
                        dfs(grid, visited, i, j);
                    }
                }
            }

            return result;
        }

        int[][] dir = {
                {0, 1}, // 右
                {1, 0}, // 下
                {-1, 0}, // 上
                {0, -1} // 左
        }; // 代表遍历的四个方向
        // 深搜
        private void dfs(char[][] grid, boolean[][] visited, int x, int y){
            for (int i = 0; i < 4; i++) {
                // 按照方向搜索
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];
                // 越界处理
                if (nextX < 0 || nextX >= grid.length ||
                        nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }
                // 如果下一个位置没访问过，并且是陆地
                if (!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                    visited[nextX][nextY] = true;
                    dfs(grid, visited, nextX, nextY);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}