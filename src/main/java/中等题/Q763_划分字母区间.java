package 中等题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q763_划分字母区间 {
    /*字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
    返回一个表示每个字符串片段的长度的列表。
 

示例 1：

输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

*/

    @Test
    public void test(){
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));

    }

//    class Solution {
        public List<Integer> partitionLabels(String S) {
            int a[] = new int[26];//记录每个小写字母最后出现的位置
            int len = S.length();
            List<Integer> res = new ArrayList();
            int start = 0;//片段的起始位置
            int end = 0;//片段的结束位置

            for(int i = 0; i < len; i++) {
                a[S.charAt(i) - 'a'] = i;
            }

            for(int i = 0; i < len; i++) {
                end = Math.max(end, a[S.charAt(i) - 'a']);
                if(end == i) {//说明后面的片段没有出现重复的字母了
                    res.add(end - start + 1);
                    start = end + 1;//新的起始位置是结束位置 + 1
                }
            }

            return res;
        }
//    }
}
