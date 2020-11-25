package 简单题;

import java.util.Arrays;

public class Q42_连续子数组的最大和 {
    /*
    * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    * */





    /*
    * 动态规划解析：
状态定义： 设动态规划列表 dpdp ，dp[i]dp[i] 代表以元素 nums[i]nums[i] 为结尾的连续子数组最大和。

为何定义最大和 dp[i]dp[i] 中必须包含元素 nums[i]nums[i] ：保证 dp[i]dp[i] 递推到 dp[i+1]dp[i+1] 的正确性；如果不包含 nums[i]nums[i] ，递推时则不满足题目的 连续子数组 要求。
转移方程： 若 dp[i-1] \leq 0dp[i−1]≤0 ，说明 dp[i - 1]dp[i−1] 对 dp[i]dp[i] 产生负贡献，即 dp[i-1] + nums[i]dp[i−1]+nums[i] 还不如 nums[i]nums[i] 本身大。

当 dp[i - 1] > 0dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]dp[i]=dp[i−1]+nums[i] ；
当 dp[i - 1] \leq 0dp[i−1]≤0 时：执行 dp[i] = nums[i]dp[i]=nums[i] ；
初始状态： dp[0] = nums[0]dp[0]=nums[0]，即以 nums[0]nums[0] 结尾的连续子数组最大和为 nums[0]nums[0] 。

返回值： 返回 dpdp 列表中的最大值，代表全局最大值。 */

    class Solution {
        public int maxSubArray1(int[] nums) {
            int[] dp = new int[nums.length];;
            dp[0] = nums[0];
            for (int i = 1; i <nums.length ; i++) {
                if (dp[i-1] < 0) dp[i] = nums[i];
                else dp[i]=nums[i] + dp[i-1];
            }
            Arrays.sort(dp);
            return  dp[nums.length-1];
        }

        //优化
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];;
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i <nums.length ; i++) {
                dp[i] = Math.max(dp[i-1]+ nums[i],nums[i]);
                max = Math.max(max,dp[i]);
            }
            return max;
        }
    }






    //分治 :  忘了怎么做
//    class Solution {
//        public int maxSubArray(int[] nums) {
//            int l = maxHalf(0, nums.length / 2, nums);
//            int r = maxHalf(nums.length / 2 + 1, nums.length - 1, nums);
//
//
//
//        }
//        public int maxHalf(int l,int r,int[] nums){
//            if (r-l==1) return Math.max(nums[r]+nums[l],r)
//            int le = maxHalf(l, r / 2, nums);
//            int ri = maxHalf(r / 2 + 1, r, nums);
//        }
//    }


}
