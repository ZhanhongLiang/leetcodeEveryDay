//某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。请返回第一个只出现一次的招式名称，如不存在请返回空格。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = "abbccdeff"
//输出：'a'
// 
//
// 示例 2： 
//
// 
//输入：arr = "ccdd"
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= arr.length <= 50000 
//
// Related Topics 队列 哈希表 字符串 计数 👍 369 👎 0


package leetcode.editor.cn;

/**
 * 招式拆解 II
 * @author DY
 * @date 2026-08-22 00:12:28
 */
public class PLCR 169_DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 169_DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char dismantlingAction(String arr) {
            // 需要返回的是第一个
            // 简单思路：不用滑动窗口法，首先用hashmap记录全部
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c : arr.toCharArray()){
                map.put(c, map.getOrDefault(c,0)+1);
            }
            for(char c : arr.toCharArray()){
                if(map.get(c)==1){
                    return c;
                }
            }
            return ' ';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}