package JZOffer;

import org.junit.Test;

public class JZ58_翻转单词顺序 {
	/*输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
	为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
示例 1：
输入: "the sky is blue"
输出:"blue is sky the"
示例 2：
输入: " hello world! "
输出:"world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：
输入: "a good  example"
输出:"example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
*/
//	class Solution {
		@Test
		public void myTest(){
		   String s  =  "a good   example";
			System.out.println(reverseWords(s));
		}
		//主要使用string的 split方法
		//思路1：split分来，倒序添加，同时判断之前是不是已经添加过一个连续的空格了。  不用判断 split方法会自动剔除空格
		//思路2： 也可以使用双指针遍历
	//很多空格的特例我没有考虑到，懒得处理特例了。 其实不用处理，修改一行就行了哈哈
	//最下面是答案
		public String reverseWords(String s) {
			if (s == null || s.length() == 0) return s;
			String[] words = s.split(" ");
			StringBuilder sb = new StringBuilder();

			for (int i = words.length - 1; i >= 0; i--) {
				if (words[i].equals("")) {
					continue;
				}
				sb.append(words[i] + " ");
			}
			return sb.toString().trim();
		}

	class Solution {
		public String reverseWords(String s) {
			String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
			StringBuilder res = new StringBuilder();
			for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
				if(strs[i].equals("")) continue; // 遇到空单词则跳过
				res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
			}
			return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
		}
	}

//	}
}
