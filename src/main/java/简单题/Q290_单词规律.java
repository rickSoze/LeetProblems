package 简单题;

import java.util.HashMap;

public class Q290_单词规律 {
	/*给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true

示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
*/
	class Solution {
		public boolean wordPattern(String pattern, String s) {
			String[] words = s.split(" ");
			char[] p = pattern.toCharArray();
			if (words.length!=p.length){
			    return false;
			}

			HashMap<Character, String> map = new HashMap<>();
			for (int i = 0; i < p.length; i++) {
				if (map.get(p[i])==null){
					if (map.containsValue(words[i])){
					    return false;
					}
				    map.put(p[i],words[i]);
				}else if (!map.get(p[i]).equals(words[i])){
				    return false;
				}
			}
			return true;
		}
	}
}
