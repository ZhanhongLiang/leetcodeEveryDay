//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 343 👎 0


package leetcode.editor.cn;

/**
 * 统计封闭岛屿的数目
 * @author DY
 * @date 2026-06-04 16:37:43
 */
public class P1254_NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution solution = new P1254_NumberOfClosedIslands().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closedIsland(int[][] grid) {
            int n =  grid.length;
            int m =  grid[0].length;
            int res = 0; // 孤岛数量
            // 从边界开始
            for(int i = 0; i < n; i++){
                if(grid[i][0] == 0){dfs(grid, i, 0);}
                if(grid[i][m-1] == 0){dfs(grid, i, m-1);}
            }
            for(int j = 0; j < m; j++){
                if(grid[0][j] == 0){dfs(grid, 0, j);}
                if(grid[n-1][j] == 0){dfs(grid, n-1, j);}
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 0){
                        res++;
                        dfs(grid, i, j); // 还需要继续淹没掉，如果是统计孤岛总面积，则不用淹没
                    }
                }
            }
            return res;
        }
        // 先dfs解决
        int[][] dir = {
                {0, 1}, // 右
                {1, 0}, // 下
                {-1, 0}, // 上
                {0, -1} // 左
        };
        private void dfs(int[][] grid, int x, int y) {
            // 这个算法是从边界开始，往里深搜，将所有所有从边界开始的陆地变成海洋
            grid[x][y] = 1; // 将陆地变成海洋
            for (int i = 0; i < 4; i++){
                int nextX = x + dir[i][0]; // 下一个点
                int nextY = y + dir[i][1];
                // 越界处理
                if (nextX < 0 || nextX >= grid.length ||
                        nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }
                // 当当前地方是海洋，则继续
                if (grid[nextX][nextY] == 1) continue;
                dfs(grid, nextX, nextY);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}