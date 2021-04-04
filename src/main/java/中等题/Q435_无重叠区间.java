package 中等题;

import java.util.Arrays;

public class Q435_无重叠区间 {
	/*给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
注意:
可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:
输入: [ [1,2], [2,3], [3,4], [1,3] ]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
例 2:
输入: [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。。*/
	//贪心。如果交错，把前一个删了
	//如果包括，把大的删了
	class Solution {
		public int eraseOverlapIntervals(int[][] intervals) {
			Arrays.sort(intervals,(a1,a2)->{
				return a1[0]-a2[0]==0?a1[1]-a2[1]:a1[0]-a2[0];
			});

			int cnt=0;
			int prev=0;
			for (int i = 1; i < intervals.length; i++) {
				if (intervals[prev][1]>intervals[i][0]){
					if (intervals[prev][1]>intervals[i][1]){
						prev=i;
					}
					cnt++;
				}else {
					prev=i;
				}
			}
			return cnt;
		}
	}

	//我写的，思路一样。实现太傻比了；过不了
	class Solution2 {
		public int eraseOverlapIntervals(int[][] intervals) {
			if(intervals.length==1) return 0;
			Arrays.sort(intervals,(a1,a2)->{
				return a1[0]-a2[0]==0?a1[1]-a2[1]:a1[0]-a2[0];
			});

			int cnt=0;
			for (int i = 0; i < intervals.length; i++) {
				if (i==intervals.length-1){
					if (intervals[i-1][0]==intervals[i][0]){
						if (intervals[i-1][1]<=intervals[i][1]){
							cnt++;
							i++;
						}else {
							cnt++;
						}
					}
					else if (intervals[i-1][0]<intervals[i][0]){
						if (intervals[i-1][1]>=intervals[i][1]){
							cnt++;
						}else{
							cnt++;
							i++;
						}
					}
				}else {
					if (intervals[i][0]==intervals[i+1][0]){
						if (intervals[i][1]<=intervals[i+1][1]){
							cnt++;
							i++;
						}else {
							cnt++;
						}
					}
					else if (intervals[i][0]<intervals[i+1][0]){
						if (intervals[i][1]>=intervals[i+1][1]){
							cnt++;
						}else{
							cnt++;
							i++;
						}
					}
				}

			}
			return cnt;
		}
	}
}
