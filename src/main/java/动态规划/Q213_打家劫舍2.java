package 动态规划;

public class Q213_打家劫舍2 {
    /*你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     这意味着第一个房屋和最后一个房屋是紧挨着的。
     如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

示例 1：
输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：
输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
*/
    class Solution{
        public int rob(int[] nums) {
            int len  = nums.length;
            if (len==0) return 0;
            if (len==1) return nums[0];

            int[][] dp0 = new int[len-1][2];
            dp0[0][1]=nums[0];
            dp0[0][0]=0;

            for (int i = 1; i <len-1 ; i++) {
                dp0[i][0]= Math.max(dp0[i-1][0],dp0[i-1][1]);
                dp0[i][1] = dp0[i-1][0]+nums[i];
            }

            int max1=Math.max(dp0[len-2][0],dp0[len-2][1]);

            int[][] dp1 = new int[len][2];
            dp1[1][1]=nums[1];
            dp1[1][0]=0;

            for (int i = 2; i <len ; i++) {
                dp1[i][0]= Math.max(dp1[i-1][0],dp1[i-1][1]);
                dp1[i][1] = dp1[i-1][0]+nums[i];
            }

            int max2=Math.max(dp1[len-1][0],dp1[len-1][1]);

            return Math.max(max1,max2);

        }
    }

}
