package 简单题;

import java.util.Arrays;
import java.util.HashMap;

public class Q205_同构字符串 {
	/*给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，

同时保留字符的顺序。

两个字符不能映射到同一个字符上，但字符可以映射自己本身。
示例 1:
输入: s = "egg", t = "add"
输出: true
示例 2:
输入: s = "foo", t = "bar"
输出: false
示例 3:
输入: s = "paper", t = "title"
输出: true
*/

	//自己作的时候在如何保证顺序的问题上，我没想明白；
	//既然每个字符都有自己对应的，那么存的时候直接就存 char:char 就行了，保证了对应，自然能够保证正确性，
	// 而不应该把注意力放在总的个数上。

	//使用数组可以更快
	class Solution {
		public boolean isIsomorphic(String s, String t) {

			if (s.length()!=t.length()){
			    return false;
			}
			int[] cnts = new int[26];
			int[] cntt = new int[26];

			for (char c : s.toCharArray()) {
				cnts[c-'a']++;
			}
			for (char c : t.toCharArray()) {
				cntt[c-'a']++;
			}

			for (int i = 0; i < s.length(); i++) {

				if (cnts[s.charAt(i)-'a']!=cntt[t.charAt(i)-'a']){
				    return false;
				}
			}
			return true;
		}
	}

	class Solution1 {
		public boolean isIsomorphic(String s, String t) {
			if (s.length() != t.length()) {
				return false;
			}

			HashMap<Character, Character> map = new HashMap<>();

			for (int i = 0; i < s.length(); i++) {
				if (!map.containsKey(s.charAt(i))) {
					if (map.containsValue(t.charAt(i))) {
						return false;
					}
					map.put(s.charAt(i), t.charAt(i));
				} else {
					if (map.get(s.charAt(i)) != t.charAt(i)) {
						return false;
					}
				}
			}
			return true;
		}
	}
}
