package 简单题;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Q771_宝石与石头 {
    /* 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
示例 1:
输入: J = "aA", S = "aAAbbbb"
输出: 3
示例 2:
输入: J = "z", S = "ZZ"
输出: 0
*/



    //很简单、可以暴力、set、
    //我做的这个反而有点不太行
    class Solution {
        public int numJewelsInStones(String J, String S) {
            if (J.length()==0 || S.length()==0) return 0;

             char[] j = J.toCharArray();
             char[] s = S.toCharArray();
            Arrays.sort(j);
            Arrays.sort(s);

            int cnt=0;

            for (int i = 0; i <j.length ; i++) {
                boolean flag =false;
                for (int k=0; k <s.length ; k++) {
                    if (j[i]==s[k]){
                        cnt++;
                        flag=true;
                    }else if (flag){
                        break;
                    }
                }
            }
            return cnt;
        }
    }
}
