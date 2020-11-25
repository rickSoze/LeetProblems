package 数据结构.简单;

import java.util.ArrayList;

public class Q234_回文链表 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }









//最简单的方法：
  //把链表中的节点取到list中，然后通过双指针判断是否是回文；
    //注意，因为list取出来的是integer，所以用equals判断；
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ArrayList<Integer> list = new ArrayList<>();
            while (head!=null){
                list.add(head.val);
                head= head.next;
            }

            int l=0,r=list.size()-1;
            while (r>l){
                if (list.get(l)!=list.get(r)){
                    return false;
                }
                r--;l++;
            }
            return true;
        }
    }
}
