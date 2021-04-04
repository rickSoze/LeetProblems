package 简单题;

public class Q896_单调数列 {
	/*如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
当给定的数组 A是单调数组时返回 true，否则返回 false。

示例 1：

输入：[1,2,2,3]
输出：true
*/
	class Solution {
		public boolean isMonotonic(int[] A) {
			if (A.length<3){
			    return true;
			}
			int cnt=0;

			for (int i = 0; i < A.length-1; i++) {
				if (A[i]-A[i+1]!=0){
				    cnt=A[i]-A[i+1];
				    break;
				}
			}
			if (cnt==0){
			    return true;
			}

			for (int i = 0; i < A.length-1; i++) {
				if (cnt>0 && A[i]<A[i+1]){
				    return false;
				}
				if (cnt<0 && A[i]>A[i+1]){
					return false;
				}
			}
			return true;
		}
	}

	class Solution2 {
		public boolean isMonotonic(int[] A) {
			boolean inc = true, dec = true;
			int n = A.length;
			for (int i = 0; i < n - 1; ++i) {
				if (A[i] > A[i + 1]) {
					inc = false;
				}
				if (A[i] < A[i + 1]) {
					dec = false;
				}
			}
			return inc || dec;
		}
	}

}
