//给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号对应的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [2,4,7,8], cnt = 1
//输出：8 
//
// 
//
// 提示： 
//
// 
// 1 <= head.length <= 100 
// 0 <= head[i] <= 100 
// 1 <= cnt <= head.length 
// 
//
// 
//
// Related Topics 链表 双指针 👍 548 👎 0


package leetcode.editor.cn;

/**
 * 训练计划 II
 * @author DY
 * @date 2026-08-21 21:54:03
 */
public class LCR140_LianBiao {
    public static void main(String[] args) {
        Solution solution = new LCR140_LianBiao().new Solution();
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
        public ListNode trainingPlan(ListNode head, int cnt) {
            // 找出倒数第cnt个节点出来
            // 快慢指针法, 先让fast移动cnt步位置
            ListNode slow = head, fast = head; // 快慢指针
            while(cnt > 0){
                cnt--;
                fast = fast.next;
            }
            while(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}