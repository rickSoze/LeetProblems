package 中等题;

import java.util.LinkedList;

public class Q316_去除重复字母 {
	/*若输入为bcacc
1. b 入栈
2. c 入栈时因为字典序靠后,且栈中没出现过c,直接压栈
3. a 入栈,因为 a 的字典序列靠前且a没有出现过,此时要考虑弹出栈顶元素.
元素 c 因为在之后还有 至少一次 出现次数，所以这里可以弹出.
元素 b 之后不再出现,为了保证至少出现一次这里不能再舍弃了.
4. c 入栈时依然因为字典序靠后且栈中没出现过直接压栈
5. c 入栈时栈中已经出现过c,跳过该元素
输出结果为 bac


给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
示例 1：
输入：s = "bcabc"
输出："abc"
示例 2：
输入：s = "cbacdcbc"
输出："acdb"

	* */
	public String removeDuplicateLetters(String s) {
		LinkedList<Character> deque = new LinkedList<>();
		int[] count = new int[26];
		boolean[]exists = new boolean[26];
		// 初始化
		for(char ch : s.toCharArray()){
			count[ch - 'a']++;
		}
		// 遍历s并入栈
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (!exists[temp - 'a']){
				while (!deque.isEmpty() && deque.getLast() > temp && count[deque.getLast() - 'a'] > 0){
					exists[deque.getLast() - 'a'] = false;
					deque.removeLast();
				}
				deque.add(temp);
				exists[temp - 'a'] = true;
			}
			count[temp - 'a']--;
		}
		//返回
		StringBuilder res = new StringBuilder();
		for(char ch : deque){
			res.append(ch);
		}
		return res.toString();
	}
	class Solution {
		public String removeDuplicateLetters(String s){
			int[] cnt = new int[26];
			boolean[] vis = new boolean[26];
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				cnt[s.charAt(i)-'a']++;
			}
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (!vis[ch-'a']){
				    while (sb.length()>0&&sb.charAt(sb.length()-1)>ch&&cnt[sb.charAt(sb.length()-1)-'a']>0){
						vis[sb.charAt(sb.length()-1)-'a']=false;
				    	sb.deleteCharAt(sb.length()-1);
//							cnt[sb.charAt(sb.length()-1)-'a']--; 进栈时已经减过了

					}
				    sb.append(ch);
					vis[ch-'a']=true;
				}
					cnt[ch-'a']--;
			}
			return sb.toString();
		}
	}
}
