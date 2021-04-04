package JZOffer;

import org.junit.Test;

import java.beans.beancontext.BeanContext;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class JZ59_滑动窗口的最大值 {
	/*给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/
//	class Solution {
	@Test
	public void myTest(){
		int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
		for (int i : maxSlidingWindow(ints, 3)) {
			System.out.println(i);
		}
	}
	
		//思路1：双指针遍历，如果l走的一步是最大值，怎么才能得到新的最大值呢？最大堆？
	//效率低到可怕！！
	//这道题在LeetCode上时hard，但是在JZ上是简单题 :)   不过考虑到时间复杂度，确实是困难题
	//最优解： 通过单调队列得到最新的最大值，单调队列获取最大值的时间复杂度O1 因此总的时间复杂度是On
		public int[] maxSlidingWindow(int[] nums, int k) {
			int len = nums.length;
			int[] res = new int[len - k + 1];
			int max=0,pos=0;
			int l=0,r=k-1;
			PriorityQueue<Integer> heap = new PriorityQueue<>(k,
					(o1, o2) -> o2-o1
			);
			for (int i = 0; i < k; i++) {
				heap.add(nums[i]);
			}
			while (r<len){
				if (nums[l]==heap.peek()){
				    res[pos++]=heap.poll();
				}else {
					res[pos++]=heap.peek();
					heap.remove(nums[l]);
				}
				l++;
				r++;
				if (r==len){
					break;
				}
				heap.add(nums[r]);
			}
			return res;
		}
//	}

	class Solution {
		//关键是在添加新元素时更新队列中的最大值，因此通过递减的单调队列，添加新元素时把队列中所有小于新元素的值全部删了即可
		public int[] maxSlidingWindow(int[] nums, int k) {
			if(nums.length == 0 || k == 0) return new int[0];
			Deque<Integer> deque = new LinkedList<>();
			int[] res = new int[nums.length - k + 1];
			// 未形成窗口
			for(int i = 0; i < k; i++) {
				while(!deque.isEmpty() && deque.peekLast() < nums[i])
					deque.removeLast();

				deque.addLast(nums[i]);
			}
			res[0] = deque.peekFirst();
			// 形成窗口后
			for(int i = k; i < nums.length; i++) {
				if(deque.peekFirst() == nums[i - k])
					deque.removeFirst();
				while(!deque.isEmpty() && deque.peekLast() < nums[i])
					deque.removeLast();
				deque.addLast(nums[i]);
				res[i - k + 1] = deque.peekFirst();
			}
			return res;
		}
	}

}
