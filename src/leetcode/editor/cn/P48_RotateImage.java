//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 2294 👎 0


package leetcode.editor.cn;

/**
 * 旋转图像
 * @author DY
 * @date 2026-08-11 19:59:10
 */
public class P48_RotateImage {
    public static void main(String[] args) {
        Solution solution = new P48_RotateImage().new Solution();
        // 测试用例1
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 调用待测试方法
        solution.rotate(matrix);

        // 打印结果
       Solution.printMatrix(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            // 48 数组题目
            // 先把二维矩阵沿对角线反转，然后反转矩阵每一行，结果就是顺时针反转整个矩阵
            // 按照每行遍历一遍
            int n = matrix.length; // 行数
            int m = matrix[0].length; // 列数
            // 只要遍历到 n / 2 行即可
            for (int i = 0; i <= n / 2; i++) {
                // 先按对角线反转
                for (int j = i; j < m - 1; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            // 反转每一行
            for (int i = 0; i < n; i++) {
                reverse(matrix[i]);
            }
        }
        public static void reverse(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}