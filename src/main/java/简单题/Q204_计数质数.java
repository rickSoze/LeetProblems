package 简单题;

import java.util.Arrays;

public class Q204_计数质数 {
    /*统计所有小于非负整数 n 的质数的数量。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例 2：
输入：n = 0
输出：0
*/
    class Solution {

        public int countPrimes(int n) {
            boolean[] isPrim = new boolean[n];
            Arrays.fill(isPrim, true);
            // 从 2 开始枚举到 sqrt(n)。
            for (int i = 2; i * i < n; i++) {
                // 如果当前是素数
                if (isPrim[i]) {
                    // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                    for (int j = i * i; j < n; j+=i) {
                        isPrim[j] = false;
                    }
                }
            }

            // 计数
            int cnt = 0;
            for (int i = 2; i < n; i++) {
                if (isPrim[i]) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
