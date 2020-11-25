package 中等题;

import java.util.Arrays;

public class Q416_分割等和子集 {
    /*给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，
    使得两个子集的元素和相等。

注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
    * */


    // 动态规划 背包问题
    class Solution {
        public boolean canPartition(int[] nums) {
            Arrays.sort(nums);



            return true;
        }

        public int getSum(int[] nums,int start,int end){
            int sum=0;
            for (int i = start; i <=end ; i++) {
                sum+=nums[i];
            }
            return sum;
        }
    }
}
