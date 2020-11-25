package 动态规划;

public class Q70_爬楼梯 {
    class Solution {
        public int climbStairs(int n) {
            if (n<=2) return n;
            int p=1,q=1,r=2;
            for (int i = 0; i < n ; i++) {
               p=q;
               q=r;
               r=p+q;
            }
            return r;
        }
    }
}
