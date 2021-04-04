package JZOffer;

import java.util.HashSet;

public class JZ03_数组中的重复数字 {
	/*找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
*/
	class Solution {
		//最优解：时间On空间O1
		//当我们在位置i遇到一个数m时，如果m不等于i，把这个数m和数组中m位置的数进行交换，如果数组中m位置的数正好也是m，返回
		//如果不是，一直交换直到找到重复数字为止
		//注意前提是元素大小小于数组长度

		public int findRepeatNumber(int[] nums) {
			for (int i = 0; i < nums.length; i++) {
				while (nums[i]!=i){
					if (nums[i]==nums[nums[i]]){
					    return nums[i];
					}
					int tmp=nums[i];
					nums[i]=nums[tmp];
					nums[tmp]=tmp;
				}
			}
			return 1;
		}

		public int findRepeatNumber1(int[] nums) {
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {
				if (set.contains(nums[i])){
				    return nums[i];
				}else {
					set.add(nums[i]);
				}
			}
			return 0;
		}

		//优化
		public int findRepeatNumber2(int[] nums) {
			int[] cnt = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				if (cnt[nums[i]]!=0){
					return nums[i];
				}else {
					cnt[nums[i]]=1;
				}
			}
			return 0;
		}
	}
}
