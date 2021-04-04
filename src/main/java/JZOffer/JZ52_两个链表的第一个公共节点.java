package JZOffer;

public class JZ52_两个链表的第一个公共节点 {
	class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  //思路1：先遍历一条链表，存到set里面，再遍历另一条，遇到的第一个在set里的即是相交的第一个节点
	//考虑到题目要求使用o1空间复杂度，不实现思路1了。
  //思路2：把链表变成A->B  和 B->A  两条，长度一样，那么在两条链表最末尾的地方就是他们的公共节点
	//我不知道怎么写出这两条链表。。。
	//下面的方法不会形成两条满足条件的链表，成了一个链表环。
	//实际上并不需要形成两条链表，我也想到过到末尾的时候直接指到另一个链表头即可，但是没有实现。
	public class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			ListNode a=headA;
			ListNode b=headB;
			while (a.next!=null){
				a=a.next;
			}
			while (b.next!=null){
				b=b.next;
			}
			a.next=headB;
			b.next=headA;
			while (headA!=null){
				if (headA==headB){
				    return headA;
				}
				headA=headA.next;
				headB=headB.next;
			}
		  return null;
		}
	}

	//答案：一模一样的思路，但是我写不出来 :)
	//如果无交点，到长链表末尾的时候，两个指针同时指向null，退出循环。
	public class Solution1 {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			ListNode A = headA, B = headB;
			while (A != B) {
				A = A != null ? A.next : headB;
				B = B != null ? B.next : headA;
			}
			return A;
		}
	}

}
