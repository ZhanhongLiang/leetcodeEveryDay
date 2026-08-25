//请设计一个自助结账系统，该系统需要通过一个队列来模拟顾客通过购物车的结算过程，需要实现的功能有： 
//
// 
// get_max()：获取结算商品中的最高价格，如果队列为空，则返回 -1 
// add(value)：将价格为 value 的商品加入待结算商品队列的尾部 
// remove()：移除第一个待结算的商品价格，如果队列为空，则返回 -1 
// 
//
// 注意，为保证该系统运转高效性，以上函数的均摊时间复杂度均为 O(1) 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//["Checkout","add","add","get_max","remove","get_max"]
//[[],[4],[7],[],[],[]]
//
//输出: [null,null,null,7,4,7]
// 
//
// 示例 2： 
//
// 
//输入: 
//["Checkout","remove","get_max"]
//[[],[],[]]
//
//输出: [null,-1,-1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= get_max, add, remove 的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
//
// 
//
// Related Topics 设计 队列 单调队列 👍 538 👎 0


package leetcode.editor.cn;

/**
 * 设计自助结算系统
 * @author DY
 * @date 2026-08-22 15:58:49
 */
public class PLCR 184_DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 184_DuiLieDeZuiDaZhiLcof().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Checkout {
        // 维护两个队列，一个是普通队列， 一个是单调递减队列
        Deque<Integer> queue = null;
        Deque<Integer> maxQueue = null;
        public Checkout() {
            queue = new ArrayDeque<>();
            maxQueue = new ArrayDeque<>();
        }

        public int get_max() {
            if(maxQueue.isEmpty()){
                return -1;
            }
            return maxQueue.peekFirst();
        }

        public void add(int value) {
            queue.offerLast(value); // 队尾添加
            // 维护单调递减队列
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < value){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(value);
        }

        public int remove() {
            if(queue.isEmpty()){
                return -1;
            }
            // 先取出即将删除的队头
            int value = queue.pollFirst();

            if (!maxQueue.isEmpty() && value == maxQueue.peekFirst()){
                maxQueue.pollFirst();
            }
            return value;
        }
    }

    /**
     * Your Checkout object will be instantiated and called as such:
     * Checkout obj = new Checkout();
     * int param_1 = obj.get_max();
     * obj.add(value);
     * int param_3 = obj.remove();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}