package 中等题;

public class Q338_比特位计数 {
    /*给定一个非负整数num。对于0 ≤ i ≤ num 范围中的每个数字i，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例2:

输入: 5
输出: [0,1,1,2,1,2]
。*/


    class Solution {
        public int[] countBits(int num) {
            int[] nums = new int[num + 1];
            for (int i = 0; i <=num ; i++) {
                nums[i]  = getCount(i);
            }
            return nums;
        }

        public int getCount(int n) {
            int dis = 0;
            while (n != 0) {
                if ((n & 1) % 2 == 1) {
                    dis++;
                }
                n = n >> 1;
            }
            return dis;
        }
    }
   //动态规划，后一个的1的数量是前一个的1的数量 + 1，但是由于2的次方数只有一个1，所以每次遇到2的次方数，就重新计数
    class Solution2 {
        public int[] countBits(int num) {
            int[] bits = new int[num + 1];
            int high=0;
            for (int i = 1; i <= num; i++) {
                if ((i&(i-1))==0){
                    high=i;
                }
                bits[i]=bits[i-high]+1;
            }
            return bits;
        }
    }
}
