package JZOffer;

public class JZ25_合并两个排序的链表 {
	/**/
	class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode ptemp = new ListNode(0);
			ListNode p = ptemp;

			while(l1!=null &&l2!=null){
				if (l1.val<=l2.val){
					p.next = l1;
					p = p.next;
					l1 = l1.next;
				}else{
					p.next = l2;
					p=p.next;
					l2 = l2.next;
				}
			}

			if (l1==null) p.next = l2;
			if (l2==null) p .next = l1;
			return ptemp.next;
		}
	}
}
