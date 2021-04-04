package JZOffer;

public class JZ11_旋转数组中的最小数字 {
	/*
	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
	该数组的最小值为1。
示例 1：
输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出0
*/
	//思路1：遍历，遇到递减的就返回
	//思路2： 这种遍历一次就能得到结果的一般都会使用二分法= = ； 我考虑一下二分法
	//没做出来，不过接近了。
	//注意细节处理，当m和r对应值相同时无法确定最小值在左边区间还是右边区间，于是通过r--来缩小区间。
	class Solution {
		public int minArray(int[] numbers) {
			int l=0,r=numbers.length-1;
			while (l!=r){
			if (numbers[l]>=numbers[r]){
			    int m = (r+l)/2;
			    if (numbers[m]<numbers[r]){ //没有考虑等于时无法判断区间的问题
			        r=m;
			    }else { //小错误， l=m+1;
			    	l=m;
				}
			}
			}
			return numbers[r];
		}
	}
	class Solution2 {
		public int minArray(int[] numbers) {
			int i = 0, j = numbers.length - 1;
			while (i < j) {
				int m = (i + j) / 2;
				if (numbers[m] > numbers[j]) i = m + 1;
				else if (numbers[m] < numbers[j]) j = m;
				else j--;
			}
			return numbers[i];
		}
	}

}
