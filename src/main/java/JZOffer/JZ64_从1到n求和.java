package JZOffer;

public class JZ64_从1到n求和 {
	/*求 1+2+...+n ，
	要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

示例 1：
输入: n = 3
输出:6
示例 2：
输入: n = 9
输出:45
*/
	class Solution {
		//思路1： 等差数列求和，n(n+1)/2
		//显然不满足条件，这种问题肯定需要用位运算。    并没有用到位运算哈哈哈
		//位运算不会，感觉可以转换为对数形式，然后在转换回来，但是涉及到pow函数。 总之不会。

		//最优解： 使用逻辑运算符的短路效应在进行递归相加的时候进行终止判断。
		public int sumNums1(int n) {
			if(n == 1) return 1;  	//使用了if，不行
			n += sumNums(n - 1);
			return n;
		}

		
		//以下才是最优解
		int res = 0;
		public int sumNums(int n) {
			boolean x = n > 1 && sumNums(n - 1) > 0;
			//当n等于1时，由于&&运算前面为假 后面就会自动停止，所以可以达到终止递归的效应
			res += n;
			return res;
		}
	}
}
