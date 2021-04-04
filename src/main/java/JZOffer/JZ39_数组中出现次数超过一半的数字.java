package JZOffer;

import java.util.Arrays;

public class JZ39_数组中出现次数超过一半的数字 {
	/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素
示例1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
*/

	class Solution {

//第一思路： 直接排序，输出中间那个数
//		public int majorityElement(int[] nums) {
//			Arrays.sort(nums);
//			return nums[nums.length/2];
//		}

//第二思路：空间换时间，当我遍历整个数组的时候，如果有一个值的出现次数已经超过了1/2那么这个就是返回值
//直接用hash实现，但是感觉不会很高效，虽然只遍历一次，但是涉及到hash里的运算

		/*
		* 答案最优解：  摩尔投票法
		* 众数一定多余其他数的个数和
		* 假定一个众数，当遇到这个数时，vote+1，否则vote-1
		* 当vote等于0的时候，让当前这个数成为假定的众数。
		* 反复进行，最后剩下的那个假定的众数一定是真正的众数，因为众数可以把所有其他的数都干掉就剩下自己。
		* 时间On  空间O1
		* */
		public int majorityElement(int[] nums) {
			int res=0;
			int vote=0;

			for (int i = 0; i < nums.length; i++) {
				if (vote==0){
					res=nums[i];
				}
				if (res==nums[i]){
				    vote++;
				}else {
					vote--;
				}
			}
			return res;
		}
	}
}
