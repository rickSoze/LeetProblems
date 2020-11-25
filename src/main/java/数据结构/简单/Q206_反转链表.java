package 数据结构.简单;


public class Q206_反转链表 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev=null;
            ListNode curr=head;

            while (curr!=null){
               ListNode temp = curr.next;
               curr.next = prev;
               prev = curr;
               curr = temp;
            }

            return prev;
        }
    }



}
