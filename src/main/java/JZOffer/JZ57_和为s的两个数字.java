package JZOffer;

import java.util.HashSet;

public class JZ57_和为s的两个数字 {
	/*输入一个递增排序的数组和一个数字s，在数组中查找两个数，
	使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
*/
	//思路1：暴力遍历------>超时
	//思路2：在找第二个数字的时候采用二分法  ？不会实现
	//思路3：第一次遍历的时候把数字加到集合里面，然后看差值是否在集合中；  时间复杂度降了。------>能过，但是效率很低
	//思路4：看了一眼评论，提到双指针；想了一下，还是不会；   本来是很简单的。。。。。


//	提醒一下，判断条件最好不要用相加后的结果，应该用target - nums[i] 跟 nums[j]比较，这样保证不会溢出。
//	虽然这题中不会出错。同样的例子还有二分查找，(left + right) / 2 可以用left + ((rigth - left) >> 1))代替

	class Solution1 {
		public int[] twoSum(int[] nums, int target) {
			int[] res = new int[2];
			for (int i = 0; i < nums.length; i++) {
				for (int j = i; j <nums.length ; j++) {
					if (nums[i]+nums[j]==target){
					    res[0]=nums[i];
					    res[1]=nums[j];
						return res;
					}else if (nums[i]+nums[j]>target){
					    break;
					}
				}
			}
			return res;
		}
	}

	class Solution {
		public int[] twoSum(int[] nums, int target) {
			int[] res = new int[2];
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {

				if (set.contains(target-nums[i])){
				    res[0]=nums[i];
				    res[1]=target-nums[i];
				    return res;
				}

				set.add(nums[i]); //如果放在前面无法避免目标是偶数，当前是其1/2且只有一个
			}
			return res;
		}
	}

	class Solution4 {
		public int[] twoSum(int[] nums, int target) {
			int l=0,r=nums.length-1;

			while (r>l){
				int sum=nums[r]-nums[l];
				if (sum==target){
				    return new int[]{nums[l],nums[r]};
				}else if(sum>target){
					r--;
				}else {
					l++;
				}
			}
			return null;
		}
	}
}
