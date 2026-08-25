//字母迷宫游戏初始界面记作 m x n 二维字符串数组 grid，请判断玩家是否能在 grid 中找到目标单词 target。 注意：寻找单词时 必须 按照字
//母顺序，通过水平或垂直方向相邻的单元格内的字母构成，同时，同一个单元格内的字母 不允许被重复使用 。 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n = grid[i].length 
// 1 <= m, n <= 6 
// 1 <= target.length <= 15 
// grid 和 target 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode.cn/problems/word-search/ 
//
// 
//
// 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 848 👎 0


package leetcode.editor.cn;

/**
 * 字母迷宫
 * @author DY
 * @date 2026-08-24 22:48:48
 */
public class PLCR 129_JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 129_JuZhenZhongDeLuJingLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // Y神的坐标法
        private int[][] dirs = {
                {1, 0},   // 下
                {-1, 0},  // 上
                {0, 1},   // 右
                {0, -1}   // 左
        };
        public boolean wordPuzzle(char[][] grid, String target) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (backtrack(grid,target,i,j,0)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] grid,String target,int row, int col, int index){
            // 递归出口
            // 越界
            if (row < 0 || row >= grid.length
                    || col < 0 || col >= grid[0].length){
                return false;
            }
            // 遍历的时候会讲该格子变成 # ，代表访问过
            // 如果当前格子已经被占用过, 则返回false，也就是已经访问过了
            if (grid[row][col] == '#'){
                return false;
            }
            // 字符不匹配
            if(grid[row][col] != target.charAt(index)){
                return false;
            }
            // 如果index达到了target的长度，代表已经存在了
            if (index == target.length() - 1){
                return true;
            }
            // 否则继续在row位置上下左右继续递归
            char c = grid[row][col]; // 原字符串保留
            grid[row][col] = '#';

            for(int[] dir : dirs){
                int nx = row + dir[0];
                int ny = col + dir[1];
                // 继续四周递归
                // 如果上一层是已经返回了成功, 则代表已经找到了,到index为止都找到了
                // 需要恢复原字符串，返回true即可
                if (backtrack(grid,target,nx,ny,index+1)){
                    grid[row][col] = c; // 恢复 因为这个递归是基于整个grid某个起点开始的，所以必须每次都要恢复
                    return true;
                }
            }
            // 恢复同时，得返回false
            grid[row][col] = c;
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}