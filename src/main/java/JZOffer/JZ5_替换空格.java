package JZOffer;

public class JZ5_替换空格 {
	/*请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
*/
	class Solution {
		public String replaceSpace(String s) {
			if (s==null || s.length()==0){
			    return s;
			}
			StringBuilder sb = new StringBuilder();
			int len= s.length();
			for (int i = 0; i < len; i++) {
				if (s.charAt(i)==' '){
				    sb.append("%20");
				}else {
					sb.append(s.charAt(i));
				}
			}
			return sb.toString();
		}
	}
	//利用数组实现，关键方法	String newStr = new String(array, 0, size);
	class Solution2 {
		public String replaceSpace(String s) {
			int length = s.length();
			char[] array = new char[length * 3];
			int size = 0;
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				if (c == ' ') {
					array[size++] = '%';
					array[size++] = '2';
					array[size++] = '0';
				} else {
					array[size++] = c;
				}
			}
			String newStr = new String(array, 0, size);
			return newStr;
		}
	}
}
