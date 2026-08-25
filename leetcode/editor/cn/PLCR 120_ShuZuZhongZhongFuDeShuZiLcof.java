//设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。 
//
// 
//
// 示例 1： 
//
// 
//输入：documents = [2, 5, 3, 0, 5, 0]
//输出：0 或 5
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ documents[i] ≤ n-1 
// 2 <= n <= 100000 
// 
//
// 
//
// Related Topics 数组 哈希表 排序 👍 1259 👎 0


package leetcode.editor.cn;

/**
 * 寻找文件副本
 * @author DY
 * @date 2026-08-20 20:22:23
 */
public class PLCR 120_ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 120_ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatDocument(int[] documents) {
//            // 思路1: 哈希表
////            HashMap<Integer, Integer> map = new HashMap<>();
//            HashSet<Integer> set = new HashSet<>();
//            for (int id : documents) {
//                if(set.contains(id))
//                    return id;
//                set.add(id);
//            }
//            return -1;
            // 思路2: 下标映射法
            for(int i = 0; i < documents.length; i++){
                // 和287寻找重复数类似的做法
                // 需要设定当前数需要和数组下标一致才对, 如果不一致那就代表肯定是重复
                // 如果当前数字已经在正确位置，继续
                while(documents[i] != i){
                    // 当前数字应该放的位置
                    int targetIndex = documents[i];
                    // 如果目标位置已经有相同数字，说明重复
                    if (documents[targetIndex] == documents[i]) {
                        return documents[i];
                    }
                    // 交换，让数字回到对应下标位置
                    int temp = documents[i];
                    documents[i] = documents[targetIndex];
                    documents[targetIndex] = temp;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}