//某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。 
//
// 
//
// 示例 1： 
//
// 
//输入：records = [0,1,2,3,5]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：records = [0, 1, 2, 3, 4, 5, 6, 8]
//输出：7 
//
// 
//
// 提示： 
//
// 1 <= records.length <= 10000 
//
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 448 👎 0


package leetcode.editor.cn;

/**
 * 点名
 * @author DY
 * @date 2026-08-21 19:37:45
 */
public class LCR173_QueShi {
    public static void main(String[] args) {
        Solution solution = new LCR173_QueShi().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int takeAttendance(int[] records) {
            // 从头遍历数组，只要下一个数和前一个数不是递增连续就行
            // 只要下标 ！= 现在的数就是
            for(int i = 0; i < records.length; i++){
                if(records[i] != i){
                    return records[i] - 1;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}