package JZOffer;

import com.sun.istack.internal.NotNull;

public class JZ18_删除链表的节点 {
	/*给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。
注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
注意： 链表节点值不同
*/
	class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//思路1：遍历，找到，删除   不是剑指原题的话应该很简单
	//剑指原题是给出了待删除节点的指针的，需要用O1的时间删除这个节点。 思路是把这个节点后面的节点依次往前复制一位即可。
	class Solution {
		public ListNode deleteNode(ListNode head, int val) {
			if (head!= null&&head.val==val){
			    return head.next;
			}

			ListNode tmp = head,prev=null;
			while (tmp!=null){
				if (tmp.val!=val){
					prev=tmp;
					tmp=tmp.next;
				}else {
					prev.next=tmp.next;
					return head;
				}
			}
			return null;
		}
	}
}
