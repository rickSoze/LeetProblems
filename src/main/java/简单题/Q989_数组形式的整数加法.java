package 简单题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q989_数组形式的整数加法 {
	/*对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。
	例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
示例 1：
输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234
*/
//	class Solution {
	@Test
	public void myTest(){
		int[] A = {9,9,9,9,9,9,9,9,9,9};
//		int[] A = {1, 2, 0, 0};
		int K = 1;
		System.out.println(addToArrayForm(A, K));
	}

	//数组尾部不断相加、进位 即可
	public List<Integer> addToArrayForm(int[] A, int K) {
		int n = A.length;
		LinkedList<Integer> res = new LinkedList<>();
		int sum = 0, carry = 0;
		for (int i = n - 1; i >= 0 || K != 0; K = K / 10,i--) {  // 循环条件：两个数有一个没完
			int x = i >= 0 ? A[i]: 0;
			int y = K != 0 ? K % 10 : 0;

			sum = x + y + carry;
			carry = sum / 10;
			res.addFirst(sum%10);
		}
		if (carry != 0) res.add(0, carry);
		return res;
	}

	}

//}
