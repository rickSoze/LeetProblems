package 简单题;

public class Q557_反转字符串中的单词III {
/*给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。


示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"*/


    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            String[] s1 = s.split(" ");
            for (int i = 0; i <s1.length; i++) {
               sb.append(new StringBuilder(s1[i]).reverse()+" ");
            }
            return sb.toString().trim();
        }
    }
}
