package 中等题;

import javax.naming.RefAddr;

public class Q20_表示数值的字符串 {

//    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
//    但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。



    //基本方法，排除所有不是数字的组合，剩下的就是是数字的
class Solution {
    public boolean isNumber(String s) {
        if (s==null || s.length()==0 ) return false;
        char[] num = s.trim().toCharArray();
        boolean isDot=false,isNum=false,iseE=false;
        for (int i = 0; i <num.length-1 ; i++) {
            if (num[i]>='0' && num[i]<='9') isNum=true;
            else if (num[i]=='.'){
                if (isDot||iseE) return false;
                isDot = true;
            }
            else if (num[i]=='e'||num[i]=='E'){
                if (!isNum || iseE) return false;
                iseE = true;
                isNum = false;
            }else if (num[i]=='-'||num[i]=='+'){
                if (i!= 0 && num[i-1]!='e'||num[i-1]!='E') return false;
            }else return false;
        }

        return isNum;
    }
}

}
