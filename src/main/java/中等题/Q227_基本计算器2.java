package 中等题;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayDeque;
import java.util.Stack;

public class Q227_基本计算器2 {
	/*给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
整数除法仅保留整数部分。
示例 1：
输入：s = "3+2*2"
输出：7
示例 2：

输入：s = " 3/2 "
输出：1
示例 3：

输入：s = " 3+5 / 2 "
输出：5
*/

	//思路和答案一致，懒得写细节了。背痛
	class Solution {
		public int calculate(String s) {
			ArrayDeque<Integer> num = new ArrayDeque<>();
			ArrayDeque<Character> cal = new ArrayDeque<>();
			char[] chars = s.toCharArray();

			int res=0;

			for (int i = 0; i < chars.length-1; i++) {
				if (chars[i]=='*'){
					res=(num.pollLast()-'0')*(chars[i+1]-'0');
					i++;
					num.push(res);
				}else if (chars[i]=='/'){
					res=(num.pop()-'0')/(chars[i+1]-'0');
					i++;
					num.push(res);
				}else if (chars[i]=='+'){
					cal.addLast(chars[i]);
				}else if (chars[i]=='-'){
					cal.addLast(chars[i]);
				}else {
					num.push((int)chars[i]);
				}
			}
			res=0;
			for (int i = 0; i < num.size(); i++) {

			}

			return 2;
		}
	}
}
