package JZOffer;

import java.util.Stack;

public class JZ30_包含min函数的栈 {
	/*定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
	调用 min、push 及 pop 的时间复杂度都是 O(1)。
示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();   --> 返回 0.
minStack.min();   --> 返回 -2.
*/
	//第一次做这种题，看的答案
	//使用辅助栈来保存一个递减的序列作为最小值
	//当普通的栈pop元素的时候，检查辅助栈顶的元素是否和它相同，同则pop
	//每次min返回辅助栈顶的元素即可。
	class MinStack {
		 Stack<Integer> a,b;
		/** initialize your data structure here. */
		public MinStack() {
			a=new Stack<>();
			b=new Stack<>();
		}

		public void push(int x) {
			a.push(x);
			//注意避免重复最小值被弹出，使用>=
			if (b.empty()||b.peek()>=x){
			    b.push(x);
			}
		}

		public void pop() {
			//注意integer的==运算在-127 128范围之外时比较的是两个对象的==不是值是否相同
			if (a.pop().equals(b.peek())){
			    b.pop();
			}

		}

		public int top() {
			return a.peek();
		}

		public int min() {
			return b.peek();
		}
	}

}
