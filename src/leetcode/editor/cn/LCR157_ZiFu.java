//某店铺将用于组成套餐的商品记作字符串 goods，其中 goods[i] 表示对应商品。请返回该套餐内所含商品的 全部排列方式 。 
//
// 返回结果 无顺序要求，但不能含有重复的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：goods = "agew"
//输出：["aegw","aewg","agew","agwe","aweg","awge","eagw","eawg","egaw","egwa",
//"ewag","ewga","gaew","gawe","geaw","gewa","gwae","gwea","waeg","wage","weag","wega",
//"wgae","wgea"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= goods.length <= 8 
// 
//
// 
//
// Related Topics 字符串 回溯 👍 732 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 套餐内商品的排列顺序
 * @author DY
 * @date 2026-08-24 22:58:59
 */
public class LCR157_ZiFu {
    public static void main(String[] args) {
        Solution solution = new LCR157_ZiFu().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 存放最终所有排列结果
        private List<String> res = new ArrayList<>();

        // 存放当前正在构造的排列
        private StringBuilder path = new StringBuilder();

        // used[i] 表示 chars[i] 当前是否已经被使用
        private boolean[] used;

        // 将原字符串转成字符数组，方便排序和访问
        private char[] chars;
        public String[] goodsOrder(String goods) {
            // 转成字符数组
            chars = goods.toCharArray();

            // 先排序，方便后面对重复字符进行去重
            Arrays.sort(chars);

            // 初始化访问数组
            used = new boolean[chars.length];

            // 开始回溯
            backtrack();

            // List<String> 转 String[]
            return res.toArray(new String[0]);
        }
        // 经典回溯模板套题
        private void backtrack(){
            // 递归出口, 当path数组长度和goods一致
            if (path.length() == chars.length){
                res.add(path.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (used[i]){
                    continue;
                }
                // 去重
                // 如果当前字符和前一个字符相同
                // 并且前一个相同字符在当前这一层没有被使用
                // 那么选择当前字符会产生重复排列，直接跳过
                if (i > 0
                        && chars[i] == chars[i - 1]
                        && !used[i - 1]) {
                    continue;
                }
                // 做选择
                used[i] = true;
                path.append(chars[i]);

                // 递归继续选择下一个位置的字符
                backtrack();

                // 回溯：撤销刚才的选择
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}