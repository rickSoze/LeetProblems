package 数据结构.中等;

public class Q148_排序链表_归并不会 {
    /*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4*/
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  //归并排序，不会
    class Solution {
        public ListNode sortList(ListNode head) {
            ListNode pre = head;
            ListNode cur = head;
            ListNode next = cur.next;
            ListNode temp = head;

            while (cur!=null){

                while (temp!=null){

                    if (pre.val <= temp.val && temp.val>=next.val){

                    }
                }




            }
            return new ListNode(2);
        }
    }

}
