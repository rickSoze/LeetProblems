package 简单题;

public class Q665_非递减数列 {
	/*给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

示例 1:
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:
输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
。*/
	//3 4 4 6
	class Solution {
		public boolean checkPossibility(int[] nums) {
			int cnt=1;

			for (int i = 0 ; i < nums.length-1; i++) {
				if (nums[i]>nums[i+1]){
				    if (cnt==1){
				    	if (i>0 && nums[i+1]<nums[i-1]){
							nums[i+1]=nums[i];
				    	}
				        cnt--;
				    }else {
				    	return false;
					}
				}
			}
			return true;
		}
	}
}
