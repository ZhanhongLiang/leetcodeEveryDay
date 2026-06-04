//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 802 👎 0


package leetcode.editor.cn;

/**
 * 太平洋大西洋水流问题
 * @author DY
 * @date 2026-06-04 17:17:22
 */
public class P417_PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new P417_PacificAtlanticWaterFlow().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int n = heights.length;
            int m = heights[0].length;

            // 设置太平洋和大西洋, 其实就是从两者边界出发可以逆流而上到达的点集合
            boolean[][] pacific = new boolean[n][m];
            boolean[][] atlantic = new boolean[n][m];
            List<List<Integer>> ans = new ArrayList<>();
            //
            for (int i = 0; i < n; i++){
                dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
                dfs(heights, atlantic, i, m-1, Integer.MIN_VALUE);
            }

            for (int j = 0; j < m; j++){
                dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
                dfs(heights, atlantic, n-1, j, Integer.MIN_VALUE);
            }
            // 找交集合
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(pacific[i][j] && atlantic[i][j]){
                        ans.add(Arrays.asList(i, j));
                    }
                }
            }
            return ans;

        }
        // 水流问题
        // 思路, 从边界开始逆流而上，记录可以逆流而上的点, 用visted存储, 最后算他们的交集，这些就是答案
        private void dfs(int[][] heights, boolean[][] visited,int x, int y, int preH){
            // 遇到边界或者访问过的点，直接返回
            if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y]) return;
            // 判断是否可以逆流而上
            if (heights[x][y] < preH) {
                return; // 如果不能逆流，则终止递归
            }
            visited[x][y] = true; // 可以达到则为true
            dfs(heights, visited, x+1, y, heights[x][y]);
            dfs(heights, visited, x-1, y, heights[x][y]);
            dfs(heights, visited, x, y+1, heights[x][y]);
            dfs(heights, visited, x, y-1, heights[x][y]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}