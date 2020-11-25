package 简单题;

public class Q7_整数反转 {
//    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
class Solution {

    //注意溢出判断
    public int reverse(int x) {
        int ans=0;
        while (x!=0){
            int pop = x%10;
            if (ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && pop >7)) return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            ans = ans*10 + pop;
            x/=10;
        }
        return ans;
    }




    // 不要用字符串的方法，太低级了；
    public int reverse1(int x) {
        if (x==Integer.MIN_VALUE) return 0;
        if (x%10==0){
            x/=10;
        }

        if (x<0){
        StringBuilder sb = new StringBuilder(-x+"");
            sb.reverse();
            if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) return 0;
            return -Integer.parseInt(sb.toString());
        }

        StringBuilder sb = new StringBuilder(x+"");
        sb.reverse();
        if (Long.parseLong(sb.toString()) > Integer.MAX_VALUE) return 0;
        return Integer.parseInt(sb.toString());
    }
}

}
