package 简单题;

public class Q231_2的幂 {
    /*给定一个整数，编写一个函数来判断它是否是 2 的幂次方。*/



    //利用 一个数如果是2的整数次方，那么二进制表示的这个数一定只有一个1

    //方法2： 直接 return n&(n-1) == 0




    //方法1： 直接计算这个数的二进制表示中有几个 1
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n<=0) return false;
            int count = Integer.bitCount(n);
            return count == 1;
        }
    }

}
