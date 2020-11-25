package 数据结构.简单;

import java.util.LinkedHashMap;

public class Q160_相交链表 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //最佳解法：把两个链表对齐，他们最后的一段肯定是一样的
//    即 a + b = b + a 如果相交就一定会在同一个地方相遇，反之都得null
    public class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                a = headA == null ? headB : a.next;
                b = headB == null ? headA : b.next;
            }
            return a;
        }


        //好像存的并不是节点的地址。。
        public class Solution2 {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//            LinkedHashSet<ListNode> l = new LinkedHashSet<>();
//            Hashtable<Integer, ListNode> l = new Hashtable<>();
                LinkedHashMap<Integer, ListNode> l = new LinkedHashMap<>();
                ListNode ret = new ListNode(0);
                ListNode a = headA;
                ListNode b = headB;
                Integer i = 0;
                while (a != null) {
                    l.put(i++, a);
                    a = a.next;
                }
                while (b != null) {
                    if (l.containsValue(b)) ret.val = b.val;
                    b = b.next;
                }
                return ret;
            }
        }

        //我感觉是对的，这题是傻逼
        public class Solution {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                ListNode ret = new ListNode(0);
                if (headA == null || headB == null) return ret;
                ListNode a = headA;
                ListNode b = headB;
                loop:
                while (a != null) {
                    while (b != null) {
                        if (a == b) {
                            ret.val = a.val;
                            break loop;
                        } else b = b.next;
                    }
                    a = a.next;
                    b = headB;
                }

                return ret;
            }
        }


    }
}
