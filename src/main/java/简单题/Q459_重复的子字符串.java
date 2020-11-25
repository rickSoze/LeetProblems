package 简单题;

import java.util.logging.Level;

public class Q459_重复的子字符串 {
    /*
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * */

    //错的，做不来
    //官方答案给的KMP算法，不懂
//    class Solution {
//        public boolean repeatedSubstringPattern(String s) {
//            if (s==null || s.length()==0) return false;
//            char[] c = s.toCharArray();
//            int p=0,q=1;
//            while (){
//                if (c[p]!=c[q]){
//                    q++;
//                }
//                else {
//                    q++;
//                    p++;
//                }
//            }
//
//
//        }
//    }


    //先找出能整除的子串长度，再用substring遍历匹配即可
    class Solution1 {
        public boolean repeatedSubstringPattern(String s) {
            for (int i = 1; i < s.length(); i++) {
                if (s.length() % i == 0) {
                    String temp = s.substring(0, i);
                    boolean flag = true;
                    for (int j = i; j + i <= s.length(); j += i) {
                        if (!temp.equals(s.substring(j, j + i))) {
                            flag = false;
                        }
                    }
                    if (flag) return true;
                }
            }
            return false;
        }

    }
}

















