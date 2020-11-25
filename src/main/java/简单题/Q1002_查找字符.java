package 简单题;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1002_查找字符 {
    /*给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
    例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
你可以按任意顺序返回答案。

示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
*/

        class Solution {
            public List<String> commonChars(String[] A) {
                int[] minfreq = new int[26];
                Arrays.fill(minfreq, Integer.MAX_VALUE);
                for (String word: A) {
                    int[] freq = new int[26];
                    int length = word.length();
                    for (int i = 0; i < length; ++i) {
                        char ch = word.charAt(i);
                        ++freq[ch - 'a'];
                    }
                    for (int i = 0; i < 26; ++i) {
                        minfreq[i] = Math.min(minfreq[i], freq[i]);
                    }
                }

                List<String> ans = new ArrayList<String>();
                for (int i = 0; i < 26; ++i) {
                    for (int j = 0; j < minfreq[i]; ++j) {
                        ans.add(String.valueOf((char) (i + 'a')));
                    }
                }
                return ans;
            }
        }

}
