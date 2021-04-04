package JZOffer;

import java.util.LinkedHashMap;
import java.util.Map;

public class JZ50_第一个只出现一次的字符 {
	/*在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
示例:
s = "abaccdeff"
返回 "b"
s= ""
返回 " "
*/

	//思路1：遍历一次，存到linked-map里面。   空间On  时间On   ->效率极低。
	//思路2：用数组存数字（对于26个字母的计数题，首先应该用数组而不是集合），两次遍历。 效率会高一些，但是我感觉应该不是最优解。
	//思路2就是最优解哈哈哈
	class Solution {
		public char firstUniqChar1(String s) {
			if (s.length()==0){
			    return ' ';
			}
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

			for (int i = 0; i < s.length(); i++) {
				Integer cnt = map.get(s.charAt(i));
				if (cnt==null){
				    map.put(s.charAt(i),1);
				}else {
					map.put(s.charAt(i),cnt+1);
				}
			}

			for(Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue()==1){
				    return entry.getKey();
				}
			}
			return ' ';
		}

		//思路2
		public char firstUniqChar(String s) {
			if (s.equals("")) return ' ';
			//创建‘a'-'z'的字典
			int[] target = new int[26];
			//第一次遍历，将字符统计到字典数组
			for (int i = 0; i < s.length(); i++) {
				target[s.charAt(i) - 'a']++;
			}
			//第二次遍历，从字典数组获取次数
			for (int i = 0; i < s.length(); i++) {
				if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
			}

			return ' ';
		}
	}
}
