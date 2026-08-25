//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3871 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存
 * @author DY
 * @date 2026-08-18 22:08:08
 */
public class P146_LruCache {
    public static void main(String[] args) {
        Solution solution = new P146_LruCache().new Solution();
        // 在此处编写本地测试逻辑
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        // 双向链表节点
        class Node {
            int key;
            int value;

            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private int capacity;

        // key -> 对应的链表节点
        private Map<Integer, Node> map;

        // head：最近使用
        // tail：最久未使用
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            // 用哈希表查询某个值是否存在
            Node node = map.get(key);

            // 不存在
            if (node == null) {
                return -1;
            }

            // 访问过后，移动到头部
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);

            // key 已经存在
            if (node != null) {
                node.value = value;

                // 更新后也算最近使用
                moveToHead(node);

                return;
            }
            // key 不存在，创建新节点
            Node newNode = new Node(key, value);

            // 加入 HashMap
            map.put(key, newNode);

            // 插入链表头部
            addFirst(newNode);

            // 超出容量
            if (map.size() > capacity) {

                // 保存需要删除的尾节点
                Node removeNode = tail;

                // 从链表中删除
                remove(removeNode);

                // 从 HashMap 中删除
                map.remove(removeNode.key);
            }
        }

        // 将节点添加到链表头部
        private void addFirst(Node node) {

            // 链表为空
            if (head == null) {
                head = node;
                tail = node;
                return;
            }
            // 头插法
            node.next = head;
            head.pre = node;

            head = node;
        }

        // 删除指定节点
        private void remove(Node node) {

            // 只有一个节点
            if (head == tail) {
                head = null;
                tail = null;
                return;
            }

            // 删除头节点
            if (node == head) {
                head = head.next;
                head.pre = null;
                node.next = null;

                return;
            }

            // 删除尾节点
            if (node == tail) {
                tail = tail.pre;
                tail.next = null;
                node.pre = null;

                return;
            }

            // 删除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = null;
            node.next = null;
        }

        // 将某个节点移动到链表头部
        private void moveToHead(Node node) {

            // 本身已经是头节点
            if (node == head) {
                return;
            }

            remove(node);

            addFirst(node);
        }

    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}