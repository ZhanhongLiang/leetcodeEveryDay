//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 4099 👎 0


package leetcode.editor.cn;

/**
 * 合并两个有序链表
 * @author DY
 * @date 2026-08-19 13:23:11
 */
public class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 归并排序,典型题目
            // 处理空链表
            if (list1 == null) {
                return list2;
            }

            if (list2 == null) {
                return list1;
            }

            ListNode head = null;
            ListNode tail = null;

            // 两个链表都还有节点
            while (list1 != null && list2 != null) {

                ListNode cur;

                // 选择较小的节点
                if (list1.val <= list2.val) {
                    cur = list1;
                    list1 = list1.next;
                } else {
                    cur = list2;
                    list2 = list2.next;
                }

                // 第一次插入
                if (head == null) {
                    head = cur;
                    tail = cur;
                } else {
                    // 尾插
                    tail.next = cur;
                    tail = tail.next;
                }
            }

            // 将剩余链表直接接到尾部
            if (list1 != null) {
                tail.next = list1;
            } else {
                tail.next = list2;
            }

            return head;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}