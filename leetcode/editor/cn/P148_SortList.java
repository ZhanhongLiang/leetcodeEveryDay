//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2817 👎 0


package leetcode.editor.cn;

/**
 * 排序链表
 * @author DY
 * @date 2026-08-18 21:58:02
 */
public class P148_SortList {
    public static void main(String[] args) {
        Solution solution = new P148_SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            // 需要归并排序后合并
            return mergeSort(head);
        }

        public ListNode mergeSort(ListNode head) {
            // 递归终止条件：0个或1个节点
            if (head == null || head.next == null) {
                return head;
            }
            // 1. 快慢指针找中点
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 2. 从中间断开
            ListNode rightHead = slow.next;
            slow.next = null;

            // 递归
            // 3. 递归排序左右链表
            ListNode left = mergeSort(head);
            ListNode right = mergeSort(rightHead);

            return merge(left, right);
        }

        // 合并两个有序链表
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode newHead = null;
            ListNode tail = null;

            while (l1 != null && l2 != null) {
                ListNode cur;

                if (l1.val <= l2.val) {
                    cur = l1;
                    l1 = l1.next;
                } else {
                    cur = l2;
                    l2 = l2.next;
                }

                // 第一个节点
                if (newHead == null) {
                    newHead = cur;
                    tail = cur;
                } else {
                    // 尾插
                    tail.next = cur;
                    tail = tail.next;
                }
            }

            // 接上剩余部分
            if (l1 != null) {
                tail.next = l1;
            } else if (l2 != null) {
                tail.next = l2;
            }

            return newHead;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}