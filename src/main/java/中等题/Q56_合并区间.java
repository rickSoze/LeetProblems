package 中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56_合并区间 {
	/*给出一个区间的集合，请合并所有重叠的区间。

输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
	* */
	//思路是一样的。先排序，然后一直往右扩
	class Solution2 {
		public int[][] merge(int[][] intervals) {
			if (intervals.length == 0) {
				return new int[0][2];
			}
			Arrays.sort(intervals, new Comparator<int[]>() {
				public int compare(int[] interval1, int[] interval2) {
					return interval1[0] - interval2[0];
				}
			});
			List<int[]> merged = new ArrayList<int[]>();
			for (int i = 0; i < intervals.length; ++i) {
				int L = intervals[i][0], R = intervals[i][1];
				if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
					merged.add(new int[]{L, R});
				} else {
					merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
				}
			}
			return merged.toArray(new int[merged.size()][]);
		}
	}

	//思路简单，实现得像傻逼
	class Solution {
		public int[][] merge(int[][] intervals) {
			if(intervals.length==1) return intervals;
			Arrays.sort(intervals,(a1,a2)-> a1[0]-a2[0]==0?a1[1]-a2[1]:a1[0]-a2[0]);
//			int[][] res = new int[intervals.length][2];
			ArrayList<int[][]> res = new ArrayList<>();

			int head=intervals[0][0];
			// int prehead=0;
			int tail=intervals[0][1];

			for (int i = 1; i < intervals.length; i++) {
				if (intervals[i-1][1]>=intervals[i][0]){
					if (intervals[i][1]>=intervals[i-1][1]&&intervals[i][1]>tail){
						tail=intervals[i][1];
					}
					if(i==intervals.length-1){
						res.add(new int[][]{
								{head,tail}
						});
					}
				}else if(intervals[i][0]>tail){
					res.add(new int[][]{
							{head,tail}
					});
					// prehead=head;
					head=intervals[i][0];
					tail=intervals[i][1];
					if(i==intervals.length-1){
						res.add(new int[][]{
								{head,tail}
						});
					}
				}
			}
			if (res.size()==0){
				res.add(new int[][]{
						{head,tail}
				});
			}
			int[][] rest = new int[res.size()][2];
			for (int i = 0; i < rest.length; i++) {
				rest[i][0]=res.get(i)[0][0];
				rest[i][1]=res.get(i)[0][1];
			}
			return rest;
		}
	}

}
