package 中等题;

import java.lang.String;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.*;
import java.util.logging.Level;

public class Q49_字母异位词分组 {
	/*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
	@Test
public void myTest(){
		char[] a = new char[]{'a','b'};
		char[] b = new char[]{'b','a'};

		System.out.println(Arrays.equals(a, b));
//		String a="hell";
//		String b ="hll";
//		System.out.println(a);
//		System.out.println(a.containsAll(b));
	}

	class Solution1 {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			for (String str : strs) {
				char[] array = str.toCharArray();
				Arrays.sort(array);
				String key = new String(array);
				List<String> list = map.getOrDefault(key, new ArrayList<String>());
				list.add(str);
				map.put(key, list);
			}
			return new ArrayList<List<String>>(map.values());
		}
	}



	//变相的暴力，没啥调用
	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			List<List<String>> real = new ArrayList<List<String>>();
			for (int i = 0; i < strs.length; i++) {
				if (strs[i]!=""){
					char[] c = strs[i].toCharArray();
					ArrayList<String> res = new ArrayList<>();
					res.add(strs[i]);
					check(strs,i+1,c,res);
					real.add(new ArrayList<>(res));
				}
			}
			return real;
		}

		public void check(String[] strs,int start,char[] c,List<String> res){
			for (int i = start; i <strs.length ; i++) {
				if (strs[i]!="" && strs[i].length()==c.length){
					boolean flag=true;
					int[] words = new int[26];
					char[] c1 = strs[i].toCharArray();
					for (int i1 = 0; i1 < c1.length; i1++) {
						words[c[i1]-'a']++;
						words[c1[i1]-'a']--;
					}
					for (int i1 = 0; i1 < words.length; i1++) {
						if (words[i1]!=0){
						    flag=false;
						}
					}
					if (flag){
					    res.add(strs[i]);
					    strs[i]="";
					}
				}
			}
		}
	}

	//很愚蠢的暴力
	class Solution13 {
		public List<List<String>> groupAnagrams(String[] strs) {
			List<List<String>> real = new ArrayList<List<String>>();
			for (int i = 0; i < strs.length; i++) {
				if (strs[i]!=""){
					char[] c = strs[i].toCharArray();
					ArrayList<String> res = new ArrayList<>();
					res.add(strs[i]);
					check(strs,i+1,c,res);
					real.add(new ArrayList<>(res));
				}
			}
			return real;
		}

		public void check(String[] strs,int start,char[] c,List<String> res){
			for (int i = start; i <strs.length ; i++) {
				if (strs[i]!="" && strs[i].length()==c.length){
					char[] c1 = strs[i].toCharArray();
					Arrays.sort(c1);
					Arrays.sort(c);
					if (Arrays.equals(c1,c)){
						res.add(strs[i]);
						strs[i]="";
					}
				}
			}
		}
	}

}
