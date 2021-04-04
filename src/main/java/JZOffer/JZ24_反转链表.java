package JZOffer;

import org.junit.Test;

public class JZ24_反转链表 {
	/*定义一个函数，输入一个链表的头节点，
	反转该链表
	并输出反转后链表的头节点。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

*/
	class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  //注意反转过程中的细节即可。
	class Solution {
		public ListNode reverseList(ListNode head) {
			if(head == null) return head;

			ListNode curr,prev,next;
			curr=head;
			prev=null;

			while (curr!=null){
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			return prev;
		}
	}
}
