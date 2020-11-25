package 数据结构.中等;

import java.util.HashSet;

public class Q142_环形链表II {
/*    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。
    说明：不允许修改给定的链表。
          

    示例 1：
    输入：head = [3,2,0,-4], pos = 1
    输出：tail connects to node index 1
    解释：链表中有一个环，其尾部连接到第二个节点。
*/


/*
* 最优解用双指针，通过快慢指针步数的关系计算得出环首；
* 感觉需要数学，我选择放弃
*
* */





    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
//            ListNode a=head,b=head;
//            a=a.next;
//            b=b.next.next;
//            int cnt=0;
//            while (a!=null && b!= null){
//                if (a==b) {
//                    return a.next;
//                }
//                a=a.next;
//                b=b.next.next;
//                cnt++;
//            }
//            return null;


       /**     HashMap<Integer, ListNode> map = new HashMap<>();
            ListNode p=head;
            int k=0;
            while (p!=null){
                if (map.values().contains(p)) return p;
                map.put(k++,p);
                p=p.next;
            }
            return null;
            //这他妈都能去用map，憨得一笔
        */
            ListNode p=head;
            HashSet<ListNode> set = new HashSet<>();
            while (p!=null){
                if (set.contains(p)) return p;
                set.add(p);
                p=p.next;
            }
            return null;
        }


    }

}
