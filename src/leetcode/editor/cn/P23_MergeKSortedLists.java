//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 锦标赛排序 👍 3265 👎 0


package leetcode.editor.cn;

/**
 * 合并 K 个升序链表
 * @author DY
 * @date 2026-08-19 00:02:25
 */
public class P23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23_MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            // 归并排序
            if (lists == null || lists.length == 0) {
                return null;
            }

            return mergeSort(lists, 0, lists.length - 1);
        }
        // 递归分治
        private ListNode mergeSort(ListNode[] lists, int left, int right) {
            // 只剩一个链表
            if (left == right) {
                return lists[left];
            }

            int mid = left + (right - left) / 2;

            // 分别合并左右两部分
            ListNode l1 = mergeSort(lists, left, mid);
            ListNode l2 = mergeSort(lists, mid + 1, right);

            // 合并两个有序链表
            return merge(l1, l2);
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