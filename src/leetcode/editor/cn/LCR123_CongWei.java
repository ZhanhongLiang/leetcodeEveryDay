//书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放
//回到书架上。请倒序返回这个书单链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [3,6,4,1]
//
//输出：[1,4,6,3]
// 
//
// 
//
// 提示： 
//
// 0 <= 链表长度 <= 10000 
//
// Related Topics 栈 递归 链表 双指针 👍 495 👎 0


package leetcode.editor.cn;

/**
 * 图书整理 I
 * @author DY
 * @date 2026-08-21 19:48:37
 */
public class LCR123_CongWei {
    public static void main(String[] args) {
        Solution solution = new LCR123_CongWei().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public int[] reverseBookList(ListNode head) {
            // 简单，顺序放到数组里面,后反转数组，但是如果用数组，那么就多出O(n)空间复杂度
            // 如果是需要O(1)空间复杂度， O(n)时间复杂度， 得其他最优解
            int len = 0; // 链表长度
            ListNode cur = head;
            while(cur != null){
                len++;
                cur = cur.next;
            }
            int[] res = new int[len];
            int index = 0;
            cur = head; // 需要重新指向
            while(cur != null){
                res[index++] = cur.val;
                cur = cur.next;
            }
            reverse(res,0,len-1);
            return res;
        }
        private void reverse(int[] res, int start, int end) {
            while(start < end){
                int temp = res[start];
                res[start] = res[end];
                res[end] = temp;
                start++;
                end--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}