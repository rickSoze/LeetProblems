package 简单题;

public class Q415_字符串相加 {
    class Solution {
        public String addStrings(String num1, String num2) {
            int i= num1.length()-1;
            int j= num2.length()-1;
            int add=0;                      // add是进位
            StringBuffer sb= new StringBuffer();

            while (i>=0||j>=0||add!=0){   //add！= 0   举例    98+31, 9+2 res得21， add =2 ，这次循环没有把2append
                                            // 所以当两个字符串一样长的时候需要考虑最高位相加之后会不会大于10
                int x= i>=0?num1.charAt(i)-'0':0;
                int y= j>=0?num2.charAt(j)-'0':0;

                int res = x+y + add;
                add = res/10;
                sb.append(res%10);
                j--;i--;
            }
            return sb.reverse().toString();

        }
    }

//一个评论的精简高级写法
    class Solution2 {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int carry = 0, i = num1.length()-1, j = num2.length()-1;
            while(i >= 0 || j >= 0 || carry != 0){
                if(i>=0) carry += num1.charAt(i--)-'0';
                if(j>=0) carry += num2.charAt(j--)-'0';
                sb.append(carry%10);
                carry /= 10;
            }
            return sb.reverse().toString();
        }
    }
}
