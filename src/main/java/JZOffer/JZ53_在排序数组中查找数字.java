package JZOffer;

public class JZ53_在排序数组中查找数字 {
	/*统计一个数字在排序数组中出现的次数。
示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
。*/
	//应该是很简单的题
	//思路1：正向遍历，遇到就计数，大于就退出。
	//思路2：通过二分法尽快找到相等的 X  二分法找到刚好小于目标的和刚好大于目标的，这两个下标相减 减1就是目标的数量
	class Solution1 {
		public int search(int[] nums, int target) {
			int cnt=0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i]>target){
				    return cnt;
				}
				if (nums[i]==target){
				    cnt++;
				}
			}
			return cnt;
		}
	}

	class Solution2 {
		public int search(int[] nums, int target) {
			int i=0,j=nums.length-1;

			//找到右边界
			while (i<=j){
				int m = (i+j)/2;
				if (nums[m]<=target){
				    i=m+1;
				}else {
					j=m-1;
				}
			}
			//剪枝
			if (j>=0&&nums[j]!=target){
			    return 0;
			}
			int right =i;
			i=0;
			j=nums.length-1;

			while (i<=j){
				int m = (i+j)/2;
				if (nums[m]<target){
					i=m+1;
				}else {
					j=m-1;
				}
			}
			int left =j;
			return right-left-1;
		}
	}
}
