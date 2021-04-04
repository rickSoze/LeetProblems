package 简单题;

public class Q643_子数组最大平均数1 {
	/*给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
示例：

输入：[1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75*/
	class Solution {
		//简单的滑动窗口，注意不要每个窗口都循环，会超时。
		public double findMaxAverage(int[] nums, int k) {
			int l=0;
			double ave=0;
			double max= - Double.MAX_VALUE;

			double sum=0;;
			for (int i = 0; i < k; i++) {
				sum += nums[i];
			}
			max=sum/k;
			l++;
			while (l+k<=nums.length){
				sum = sum + nums[l+k-1] - nums[l-1];
				ave=sum/k;
				if (ave>max){
				    max=ave;
				}
				l++;
			}
			return max;
		}
	}
}
