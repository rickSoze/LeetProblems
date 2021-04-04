package JZOffer;

public class JZ49_丑数 {
	/*我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:
1是丑数。
n不超过1690。
*/
//丑数显然是已有的数乘以2\3\5得到的数，因为题目要求从小到大排序，所以问题是：
	//怎么保证当前的数乘以2和前一个数乘以3、5哪个大？
//三指针思路：a表示*2的数，b是*3，c是*5   每个位置找最小的那个，同时把对应的a或b.c加1
//也可以认为我们计算所有的2、3、5的倍数的三个数组，最终答案一定是这三个数组合并然后去重排序的结果。三个指针分别在三个数组中查找。
	class Solution {
		public int nthUglyNumber(int n) {
			int a=0,b=0,c=0;
			int[] cnt = new int[n];
			cnt[0]=1;
			for (int i = 1; i < cnt.length; i++) {
				int tmp = Math.min(Math.min(cnt[b]*3,cnt[c]*5),cnt[a]*2);
				cnt[i]=tmp;
				if (tmp==cnt[a]*2){
				    a++;
				}
				if (tmp==cnt[b]*3){
				    b++;
				}
				if (tmp==cnt[c]*5){
				    c++;
				}
			}
			return cnt[n-1];
		}
	}
}
