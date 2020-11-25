package 简单题;

import org.junit.Test;

public class Q14_最长公共前缀 {
    /*编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

    * */
//    class Solution {
//    @Test
//    public void test(){
//        System.out.println(longestCommonPrefix1(new String[]{"aca", "cba"}));
//    }
    //也可以先将整个strs排序，然后只比较第一个和最后一个的公共前缀即可




//        public String longestCommonPrefix2(String[] strs) {
//            for (int i = 0; i <strs.length ; i++) {
//
//            }
//
//        }

        public String longestCommonPrefix1(String[] strs) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                boolean flag = true;
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length()<=i ||strs[j].length()>i &&!(strs[j].charAt(i)==c) ){
                        flag = false;
                        break;
                    }
                }
                if (flag) sb.append(c);
                else return sb.toString();
            }
            return sb.toString();
        }
    }
//}
