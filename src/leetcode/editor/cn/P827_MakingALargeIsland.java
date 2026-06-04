//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。 
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？ 
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 486 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最大人工岛
 * @author DY
 * @date 2026-06-04 16:38:50
 */
public class P827_MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new P827_MakingALargeIsland().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestIsland(int[][] grid) {
            // 先遍历所有岛屿，将每个岛屿编号, 直接从2开始即可！！因为0，1已经有代表的意思了
            int n =  grid.length;
            int m =  grid[0].length;
            // key: 岛屿编号，value: 岛屿面积
            Map<Integer, Integer> map = new HashMap<>();
            int islandId = 2; // 从 2 开始编号
            int result = 0;
            // 先遍历一遍，找到对应的岛屿，赋予编号
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 1){
                        area = 0;
                        dfs(grid,i,j,islandId);
                        map.put(islandId, area);
                        result = Math.max(result, area);
                        islandId++;
                    }
                }
            }
            // 然后再逐个变1
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] == 0){
                        // 需要从i,j的四个方向开始
                        // 设置set唯一容器，因为可以防止重复添加
                        int sum = 1; // 当前这个 0 变成 1，所以先加 1

                        // 用来记录四周已经加过的岛屿编号，避免重复计算
                        Set<Integer> set = new HashSet<>();
                        for(int k = 0; k < 4; k++){
                            int nextX = i + dir[k][0];
                            int nextY = j + dir[k][1];

                            if (nextX < 0 || nextX >= n ||
                                    nextY < 0 || nextY >= m) {
                                continue;
                            }
                            int id = grid[nextX][nextY];
                            // id >= 2，说明旁边是某个已经编号的岛屿
                            if (id >= 2 && !set.contains(id)) {
                                set.add(id);
                                sum += map.get(id);
                            }
                        }
                        result = Math.max(result, sum);
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
        };
        // 当前岛屿面积
        int area;
        private void dfs(int[][] grid, int x, int y, int isInland) {
            // 需要编号
            grid[x][y] = isInland;
            area++; //面积+1, 记录每个岛屿的面积
            for(int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];
                // 边界条件, 因为不需要记录是否有遍历过
                if (nextX < 0 || nextX >= grid.length ||
                        nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }
                // 如果有陆地
                if(grid[nextX][nextY] == 1){
                    dfs(grid, nextX, nextY, isInland);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}