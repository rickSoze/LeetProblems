package 简单题;

import java.util.SimpleTimeZone;

public class Q724_寻找数组的中心索引 {
	/*给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
注意：中心索引可能出现在数组的两端。
 
示例 1：
输：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
同时, 3 也是第一个符合要求的中心索引。
*/
	class Solution {
		public int pivotIndex(int[] nums) {
			if (nums.length==0){
			    return -1;
			}
			int sum=0;
			for (int num : nums) {
				sum+=num;
			}
			int temp=0;

			//既然只是想判断两倍关系，直接乘以二不就行了吗。傻逼
			for (int i = 0; i < nums.length; i++) {

				if ((sum-nums[i])  == temp*2 ) {
					return i;
				}
				temp += nums[i];
			}
			return -1;
		}
	}
}
