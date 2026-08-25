//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 示例 1： 
//
// 
//输入：head = [4,5,1,9], val = 5
//输出：[4,1,9]
//解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2： 
//
// 
//输入：head = [4,5,1,9], val = 1
//输出：[4,5,9]
//解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
//
// 
//
// Related Topics 链表 👍 370 👎 0


package leetcode.editor.cn;

/**
 * 删除链表的节点
 * @author DY
 * @date 2026-08-21 21:41:58
 */
public class PLCR 136_ShanChuLianBiaoDeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR 136_ShanChuLianBiaoDeJieDianLcof().new Solution();
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
        public ListNode deleteNode(ListNode head, int val) {
            // 直接删除即可，没有什么
            // 需要一个虚拟头节点
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            ListNode pre = dummyNode;
            ListNode cur = head;
            while(cur != null){
                if(cur.val == val){
                    pre.next = cur.next;
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            return dummyNode.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
}