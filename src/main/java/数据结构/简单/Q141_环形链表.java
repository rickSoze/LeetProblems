package 数据结构.简单;

import java.util.HashSet;

public class Q141_环形链表 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

  //第一次自己使用双指针解决了问题，芜湖~~
    //因为如果有环的话，快慢指针在环中循环一定会因为速度差而相遇
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null ) return false;
            ListNode a=head,b=head.next;
            while (a!=null && b!= null){
                if (a==b) return true;
                a=a.next;
                if(b.next==null) return false;
                b=b.next.next;
            }
            return false;
        }
    }

  // O(n)空间,最普通的方法
    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> nodes = new HashSet<>();
            while (head != null){
                if (nodes.contains(head)){
                    return true;
                }
                nodes.add(head);
                head = head.next;
            }
            return false;
        }
    }
}
