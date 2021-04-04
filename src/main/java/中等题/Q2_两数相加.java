package 中等题;

import org.junit.Test;

public class Q2_两数相加 {
    /*给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照
    逆序的方式存储的，并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0开头。
示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

*/


    // 如果数字太大，用int就会溢出； 懒得想其他了
    //


    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);

        System.out.println(node.val);


    }
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

//    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int a=0;
            int acnt=0,bcnt=0;
            while (l1!=null){
                a+= l1.val * Math.pow(10,acnt);
                acnt++;
                l1=l1.next;
            }
            while (l2!=null){
                a+= l2.val * Math.pow(10,bcnt);
                bcnt++;
                l2=l2.next;
            }

            int flag=0;
            int mod=a%10;
            ListNode head=new ListNode(mod);
            ListNode res = head;
            while (a!=0){
                a/=10;
                if(flag!=0){
                    head.next = new ListNode(mod);
                    head=head.next;
                }
                mod = a%10;
                flag=1;
            }
            return res;
        }
//    }
}
