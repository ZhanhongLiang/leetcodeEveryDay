//读者来到图书馆排队借还书，图书管理员使用两个书车来完成整理借还书的任务。书车中的书从下往上叠加存放，图书管理员每次只能拿取书车顶部的书。排队的读者会有两种操
//作： 
//
// 
// push(bookID)：把借阅的书籍还到图书馆。 
// pop()：从图书馆中借出书籍。 
// 
//
// 为了保持图书的顺序，图书管理员每次取出供读者借阅的书籍是 最早 归还到图书馆的书籍。你需要返回 每次读者借出书的值 。 
//
// 如果没有归还的书可以取出，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["BookQueue", "push", "push", "pop"]
//[[], [1], [2], []]
//输出：[null,null,null,1]
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.pop(); // return 1, queue is [2] 
//
// 
//
// 提示： 
//
// 
// 1 <= bookID <= 10000 
// 最多会对 push、pop 进行 10000 次调用 
// 
//
// 
//
// Related Topics 栈 设计 队列 👍 807 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 图书整理 II
 * @author DY
 * @date 2026-08-22 14:28:42
 */
public class LCR125_YongLiang {
    public static void main(String[] args) {
        Solution solution = new LCR125_YongLiang().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        // 两个栈实现
        private Deque<Integer> stack1 = null;
        // 第一个栈专门负责入栈，第二个栈专门负责出栈
        private Deque<Integer> stack2 = null;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            // 这个是实现入队列操作
            stack1.push(value);
        }

        public int deleteHead() {
            // 出栈判断stack2是否有数
            if (!stack2.isEmpty()){
                return stack2.pop();
            }
            // 否则将stack1全部出栈逆序压入到stack2中，然后出栈第一个数
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            // 两个栈都为空
            if (stack2.isEmpty()) {
                return -1;
            }
            return stack2.pop();
        }


    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}