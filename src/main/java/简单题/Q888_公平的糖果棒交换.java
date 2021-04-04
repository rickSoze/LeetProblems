package 简单题;

import java.util.Arrays;

public class Q888_公平的糖果棒交换 {
	/*爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1]是 Bob 必须交换的糖果棒的大小。
如果有多个答案，你可以返回其中任何一个。保证答案存在。
示例 1：
输入：A = [1,1], B = [2,2]
输出：[1,2]
。*/
	//最初用的暴力法，LeetCode答案用的是hash表，更高效但是思路是一致的。
	// 评论区的方法更加高效巧妙。见下。 计算差值，排序数组，然后双指针遍历排序之后的数组并计算目标差值。
	class Solution {
		public int[] fairCandySwap(int[] A, int[] B) {
			int suma=0,sumb=0;
			for (int i : A) {
				suma+=i;
			}
			for (int i : B) {
				sumb+=i;
			}
			int sum = suma+sumb/2;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < B.length; j++) {
					if (sum-suma == B[j]-A[i]){
					    return new int[]{A[i],B[j]};
					}
				}
			}
			return new int[2];
		}
	}

	//将数组排序之后通过差值获取。
	class Solution2 {
		public int[] fairCandySwap(int[] A, int[] B) {
			int[] ans = new int[2];
			int sumA = 0, sumB = 0;
			for(int i: A){
				sumA += i;
			}
			for(int j: B){
				sumB += j;
			}
			Arrays.sort(A);
			Arrays.sort(B);
			int temp = sumA-(sumA+sumB)/2;
			int i = 0, j = 0;
			while(i<A.length&&j<B.length){
				if(A[i]-B[j]==temp){
					ans[0] = A[i];
					ans[1] = B[j];
					break;
				}
				else if(A[i]-B[j]>temp){
					j++;
				}
				else if(A[i]-B[j]<temp){
					i++;
				}
			}
			return ans;
		}
	}
}
