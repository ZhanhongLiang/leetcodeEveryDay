//家居整理师将待整理衣橱划分为 m x n 的二维矩阵 grid，其中 grid[i][j] 代表一个需要整理的格子。整理师自 grid[0][0] 开始 逐
//行逐列 地整理每个格子。 
//
// 整理规则为：在整理过程中，可以选择 向右移动一格 或 向下移动一格，但不能移动到衣柜之外。同时，不需要整理 digit(i) + digit(j) > 
//cnt 的格子，其中 digit(x) 表示数字 x 的各数位之和。 
//
// 请返回整理师 总共需要整理多少个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 4, n = 7, cnt = 5
//输出：18
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, m <= 100 
// 0 <= cnt <= 20 
// 
//
// 
//
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 690 👎 0


package leetcode.editor.cn;

/**
 * 衣橱整理
 * @author DY
 * @date 2026-08-24 23:04:59
 */
public class PLCR 130_JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 130_JiQiRenDeYunDongFanWeiLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0; // 全局格子变量

        private boolean[][] visited;
        public int wardrobeFinishing(int m, int n, int cnt) {
            visited = new boolean[m][n];
            backtrack(m,n,0,0,cnt);
            return count;
        }
        // 因为只能向右向下，不存在已经访问过的现象;
        private void backtrack(int m, int n, int row, int col,  int cnt){
            // 递归条件
            // 越界, 因为只能向下和向右移动, 所以只能 >= 方式越界
            // 越界
            if (row < 0 || row >= m || col < 0 || col >= n) {
                return;
            }
            // 已访问
            if (visited[row][col]) {
                return;
            }
            // 判断当前是否满足这个条件
            int digitX = digitSum(row);
            int digitY = digitSum(col);
            if (digitX + digitY > cnt){
                return;
            }
            // 否则以目前[row,col]位置递归即可
            count++;
            // 访问过
            visited[row][col] = true;
            backtrack(m, n, row + 1, col, cnt);
            backtrack(m, n, row, col + 1, cnt);
        }

        private int digitSum(int x) {
            int sum = 0;

            while (x > 0) {
                sum += x % 10;  // 取个位
                x /= 10;        // 去掉个位
            }

            return sum;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}