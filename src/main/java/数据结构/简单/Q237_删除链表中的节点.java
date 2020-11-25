package 数据结构.简单;

public class Q237_删除链表中的节点 {
//    请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。




    //删除一个节点的一般方法是把这个节点的前驱节点的next指向这个节点的后继节点，
    //但是这个问题中我们无法获取到待删除节点的前驱节点，因此需要换一个思路：
    //   即直接把待删除节点的值替换为下一个节点的，然后让待删除节点指向下一个节点的下一个节点，这样虽然没有实际删除
    //   目标节点，但是链表的结果却是一样的； 很有启发性



    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
