package JZOffer;

import java.util.ArrayList;
import java.util.Collections;

public class JZ06_从尾到头打印链表 {
	/*
	* 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
 */
	class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  //空间On 可以优化
	class Solution {
		public int[] reversePrint(ListNode head) {
			ArrayList<Integer> res = new ArrayList<>();

			while (head!=null){
				res.add(head.val);
				head= head.next;
			}
			int len = res.size();
			int[] ints = new int[len];
			for (int i = 0; i < len; i++) {
				ints[i]=res.get(len-i);
			}
			return ints;
		}
	}
	//优化空间
	class Solution2 {
		public int[] reversePrint(ListNode head) {
			int len = 0;
			while (head!=null){
				len++;
				head= head.next;
			}

			int[] ints = new int[len];
			for (int i = 0; i < len; i++) {
				ints[len-i-1]=head.val;
				head = head.next;
			}
			return ints;
		}
	}
}
