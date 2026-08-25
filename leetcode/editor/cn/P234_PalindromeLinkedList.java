//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 2295 👎 0


package leetcode.editor.cn;

/**
 * 回文链表
 * @author DY
 * @date 2026-08-18 19:39:55
 */
public class P234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234_PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            // 快慢指针法,先找到中间节点
            // 只要slow节点位置就是中间节点
            ListNode slow = head, fast = head;
            // 但其实分成奇偶数
            int n = 0;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 2. 反转 slow 开始的后半部分
            ListNode pre = null;
            ListNode cur = slow;
            while (cur != null) {
                ListNode next = cur.next;

                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // 3. 前半部分和反转后的后半部分比较
            ListNode p1 = head;
            ListNode p2 = pre;

            while (p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }

                p1 = p1.next;
                p2 = p2.next;
            }

            return true;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}