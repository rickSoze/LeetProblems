package 动态规划;

public class Q17_16_按摩师 {
    /*一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
    在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，
    替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

注意：本题相对原题稍作改动

示例 1：
输入： [1,2,3,1]
输出： 4
解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。

    * */

    class Solution2 {
        public int massage(int[] nums) {
            int len = nums.length;
            if (len==0) return 0;
            if (len==1) return nums[0];

            int[][] dp = new int[len][2];

            dp[0][0]=0;
            dp[0][1]=nums[0];
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
                dp[i][1] = dp[i-1][0]+nums[i];
            }

            return Math.max(dp[len-1][0],dp[len-1][1]);
        }
    }











    class Solution {
        public int massage(int[] nums) {
            if (nums==null || nums.length==0) return 0;
            if (nums.length==1)return nums[0];
            int[] dp = new int[nums.length];
            dp[0]=nums[0];
//            dp[1]=nums[1];
            dp[1]=nums[0]>nums[1]?nums[0]:nums[1];
            for (int i = 2; i <nums.length ; i++) {
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
            return dp[nums.length-1];
        }
    }
}
