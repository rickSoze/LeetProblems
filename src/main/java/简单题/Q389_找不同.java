package 简单题;

import java.util.Arrays;
import java.util.HashMap;

public class Q389_找不同 {

	/**强调：看到和字母数量有关的题都应该第一时间想到用长度为26的数组来存。*/

	/*给定两个字符串 s 和 t，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。
示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：
输入：s = "", t = "y"
输出："y"
示例 3：
输入：s = "a", t = "aa"
输出："a"
示例 4：
输入：s = "ae", t = "aea"
输出："a"

提示：

0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母*/
	//初步想法： 排序之后比较、转为map之后遍历。
	//修正： 直接用数组存即可。
		//总结： 排序是最坏的方法。 map、cnt计数都是一回事

		//最优解1： 计算两个字符串的char的差。得到的结果转为char即是多出来的。
		//最优解2： 把两个字符串拼起来，遍历并做异或运算。 最后出现了奇数次的字母就会留下来。

	class Solution2 {
		public char findTheDifference(String s, String t) {
			int[] cnt = new int[26];
			char[] sc = s.toCharArray();
			Arrays.fill(cnt,0);
			char[] tc = t.toCharArray();

			for (int i = 0; i < sc.length; i++) {
				cnt[sc[i]-'a']++;
			}

			for (int i = 0; i < tc.length; i++) {
				if (--cnt[tc[i]-'a']<0){
					return tc[i];
				}
			}
			return 'a';
		}

	class Solution {
		public char findTheDifference(String s, String t) {
			HashMap<Character, Integer> map = new HashMap<>();

			char[] sc = s.toCharArray();
			char[] tc = t.toCharArray();
			for (int i = 0; i < sc.length; i++) {
				Integer tmp = map.get(tc[i]);
				if (tmp==null){
					map.put(sc[i],1);
				}else {
					map.put(sc[i],tmp+1);
				}
			}

			for (int i = 0; i < tc.length; i++) {
				Integer cnt = map.get(tc[i]);
				if (cnt==null||cnt==0){
					return tc[i];
				}else {
					map.put(tc[i],cnt-1);
				}
			}
			return 'a';
		}
	}

	}
}
