package JZOffer;

import java.util.HashMap;

public class JZ35_复杂链表的复制 {
	/*请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
	每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
*/
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	class Solution {
		//思路1：遍历，然后复制。第一遍读题我没发现什么特殊的地方？
		//发现问题：题目需求是copy，即完全复制一个新的节点，只用指针的变化不叫copy。
		//问题是怎么保存random节点，有一说一没有random节点的复制链表我也没做过。

		//简单一点的思路：第一次遍历记录每个旧节点对应的新节点，第二次遍历整好random
		//复杂的思路是不会，只是减少了空间复杂度。
		public Node copyRandomList(Node head) {
			if (head==null){
			    return head;
			}
			Node cur = head;
			HashMap<Node, Node> map = new HashMap<>();
			while (cur!=null){
				map.put(cur,new Node(cur.val));
				cur=cur.next;
			}
			cur=head;
			while (cur!=null){
				map.get(cur).next= map.get(cur.next);
				map.get(cur).random = map.get(cur.random);
				cur=cur.next;
			}
			return map.get(head);
		}
	}
}
