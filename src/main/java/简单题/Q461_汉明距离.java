package 简单题;

public class Q461_汉明距离 {
    //使用现成的函数，先异或运算求出有多少个两个数字都是1
    //然后bitCount 函数计算一个二进制数中有多少个1
    class Solution2{
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

//自己写一个对1的计数器
    //通过判断最右的是否是1 然后>> 右位移；依次判断剩下的是否都是1
    class Solution{
        public int hammingDistance(int x, int y) {
            int n = x^y;
            int dis=0;
            while (n!=0){
                if ((n & 1) % 2== 1){
                    dis++;
                }
                n = n >>1;
            }
            return dis;
        }
    }



}
