//仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：stock = [2,5,7,4], cnt = 1
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：stock = [0,2,3,6], cnt = 2
//输出：[0,2] 或 [2,0] 
//
// 
//
// 提示： 
//
// 
// 0 <= cnt <= stock.length <= 10000 
// 0 <= stock[i] <= 10000 
// 
//
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 608 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 库存管理 III
 * @author DY
 * @date 2026-08-22 00:14:56
 */
public class LCR159_ZuiXiao {
    public static void main(String[] args) {
        Solution solution = new LCR159_ZuiXiao().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] inventoryManagement(int[] stock, int cnt) {
            if (cnt == 0) {
                return new int[0];
            }
            int low = 0;
            int high = stock.length - 1;
            int target = cnt - 1;
            while (low <= high) {
                int index = partition(stock, low, high);
                if (index == target){
                    break;
                }else if (index < target){
                    low = index + 1;
                }else{
                    high = index - 1;
                }
            }
            return Arrays.copyOf(stock,cnt);
        }

        // 快排选择分区变体
        private int partition(int[] nums, int low, int high) {
            // 这道题和hot100- 215一致的思路，215是找出第K大的元素 -> 找出 n - k 小的元素
            // 找出前俩最小的元素, 都不用转换了
            // 直接快排选择法
            int pivot = nums[low];
            int i = low,  j = high;
            while (i < j) {
                while (i < j && nums[j] >= pivot) j--;
                if(i < j) nums[i++] =  nums[j];
                while(i < j && nums[i] <= pivot) i++;
                if(i < j) nums[j--] =  nums[i];
            }
            // 归位
            nums[i] =  pivot;
            return i;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}