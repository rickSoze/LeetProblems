package JZOffer;

public class JZ21_让奇数位于偶数前面 {
	/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
示：
输入：nums =[1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
*/

	//思路1：由 交换  我们可以想到使用双指针，遍历时奇偶不符则交换     大佬也是这个思路，实现没问题；代码可以简化
	class Solution {
		public int[] exchange(int[] nums) {
			int l=0,r=nums.length;

			while (l<=r){
				if ((nums[l]&1)==0){
				    if ((nums[r]&1)==1){
				        int tmp=nums[l];
				        nums[l]=nums[r];
				        nums[r]=tmp;
				    }else {
				    	r--;
					}
				}else {
					l++;
				}
			}
			return nums;
		}
	}

	//简化代码
	class Solution2 {
		public int[] exchange(int[] nums) {
			int i = 0, j = nums.length - 1, tmp;
			while(i < j) {
				while(i < j && (nums[i] & 1) == 1) i++;
				while(i < j && (nums[j] & 1) == 0) j--;
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
			return nums;
		}
	}
}
