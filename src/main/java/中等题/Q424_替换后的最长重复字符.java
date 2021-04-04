package 中等题;

import org.junit.Test;

public class Q424_替换后的最长重复字符 {
	/*给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
	总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。
注意：字符串长度 和 k 不会超过104。
示例 1：
输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：

入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
*/
	/**
	 * 滑动窗口类型：
	 * 	目标是找到最长的区间，那么我们在遍历的过程中只关心最长的区间出现的那次。
	 * 	维护两个指针l、r，形成一个区间，当区间中的【总字母个数 减去 重复次数最多的字母的个数】 [不大于k的时候]
	 * 	说明可以把整个区间变为一样的字符串，那么r右移。  否则左指针右移1位，右指针右移
	 *
	 * 	在这个过程中，可能目前区间不符合  【总字母个数 减去 重复次数最多的字母的个数】 [不大于k]这个条件了，
	 * 	但是无所谓，因为区间的长度要么不变，要么变长。我们始终可以保证当前区间长度是最长的。
	 * */

	@Test
	public void myTest(){
	    String s = "ABBB";
		Solution solution = new Solution();
		System.out.println(solution.characterReplacement(s, 1));
	}

	//我的想法只能计算 BBBA这种形式的，不能解决 ABBBA这种从中间往两边扩散的情况
	class Solution {
		public int characterReplacement(String s, int k) {
			int l=0,r=0;
			int max=0;
			int times = k;

			while (l<s.length() && r<s.length()){
				if (s.charAt(l)==s.charAt(r)){
				    r++;
				}else if (times>0){
					times--;
					r++;
				}else {
					max= Math.max(r-l,max);
					l=r;
					times=k;
				}
			}
			return Math.max(max,r-l);
		}
	}
	class Solution2 {
		public int characterReplacement(String s, int k) {
			int l=0,r=0;
			int maxn=0;
			int[] cnt = new int[26];

			while (r<s.length()) {
				cnt[s.charAt(r) - 'A']++;
				maxn = Math.max(maxn, cnt[s.charAt(r) - 'A']);
				if (r - l + 1 - maxn > k) {
					cnt[s.charAt(l) - 'A']--;
					l++;
				}
				r++;
			}
			return r-l;
		}
	}

}
