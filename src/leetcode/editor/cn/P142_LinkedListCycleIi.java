//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
//
// Related Topics 哈希表 链表 双指针 👍 3025 👎 0


package leetcode.editor.cn;

/**
 * 环形链表 II
 * @author DY
 * @date 2026-04-19 18:21:29
 */
public class P142_LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142_LinkedListCycleIi().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head; // 快指针
            ListNode slow = head; // 慢指针
            while (fast != null && fast.next != null) {
                // 慢指针走一步
                slow = slow.next;
                // 快指针走两步
                fast = fast.next.next;
                if (slow == fast) {
                    // 当相遇的时候
                    // 因为x = (n-1) (y + z) + z
                    //  当n = 1 时候， x = z, 也就是fast和head的地方就是入口点
                    ListNode p = fast; // 相遇
                    ListNode q = head;
                    // 当 n > 1 时候， 也就是fast需要走多 (n - 1) 圈才能和head相遇, 这个时候就是入口点
                    while (p != q){
                        p = p.next;
                        q = q.next;
                    }
                    return p;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}