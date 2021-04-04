package 简单题;

public class Q303_区域和检索_数组不可变 {
	/*给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
实现 NumArray 类：
NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范
围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
示例：

输入：
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
[null, 1, -1, -3]
*/
	class NumArray {
		int[] real;
		int[] tmp;
		public NumArray(int[] nums) {
			real=nums;
			tmp = new int[nums.length + 1];
			for (int i = 0; i < nums.length; i++) {
				tmp[i+1] = tmp[i] + nums[i];
			}
		}

		public int sumRange(int i, int j) {
			return tmp[j+1]-tmp[i+1]+real[i];
		}
	}
}
