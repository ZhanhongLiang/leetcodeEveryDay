//给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖
//直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。 
//
// 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那
//么我们称 grid2 中的这个岛屿为 子岛屿 。 
//
// 请你返回 grid2 中 子岛屿 的 数目 。 
//
// 
//
// 示例 1： 
// 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], 
//grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
//输出：3
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
// 
//
// 示例 2： 
// 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], 
//grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
//输出：2 
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
// 
//
// 
//
// 提示： 
//
// 
// m == grid1.length == grid2.length 
// n == grid1[i].length == grid2[i].length 
// 1 <= m, n <= 500 
// grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 160 👎 0


package leetcode.editor.cn;

/**
 * 统计子岛屿
 * @author DY
 * @date 2026-06-04 15:54:52
 */
public class P1905_CountSubIslands {
    public static void main(String[] args) {
        Solution solution = new P1905_CountSubIslands().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid1.length;
            int n = grid1[0].length;
            boolean[][] visited = new boolean[m][n];
            int res = 0; // 记录子岛屿数量
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    isSubIsland = true;
                    // 如果当前没有访问过且是陆地
                    if (!visited[i][j] && grid2[i][j] == 1) {
                        visited[i][j] = true;
                        dfs(grid1,grid2,visited,i,j); // 递归找
                        if (isSubIsland){
                            res++;
                        }
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
        }; // 代表遍历的四个方
        // 记录最大面积
        // 用一个东西记录每个岛屿里面的点都属于同一个岛屿
        // 这个东西是什么呢, index索引，标记岛屿索引
        boolean isSubIsland; // 记录gird2当前访问的岛屿是否是gird1的子岛屿
        private void dfs(int [][] grid1,int[][] grid2, boolean[][] visited,int x, int y){
            // 如果当前终止条件中, 当前访问到点在grid1为海洋, 则肯定不是子岛屿
            if (grid1[x][y] == 0){
                isSubIsland = false;
            }
            for(int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0]; // 下一个点
                int nextY = y + dir[i][1];
                // 越界处理
                if (nextX < 0 || nextX >= grid2.length ||
                        nextY < 0 || nextY >= grid2[0].length) {
                    continue;
                }
                // 需要遍历该点的周围的点
                // 当访问到可以的
                if (!visited[nextX][nextY] &&  grid2[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true; // 访问过
                    dfs(grid1,grid2, visited, nextX, nextY);
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}