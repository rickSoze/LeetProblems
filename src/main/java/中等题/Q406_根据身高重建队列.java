package 中等题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q406_根据身高重建队列 {
	/**假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
	 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
	 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

示例 1：

输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
*/


	/*
	* 一般这种数对，还涉及排序的，
	* 根据第一个元素正向排序，根据第二个元素反向排序，
	* 或者根据第一个元素反向排序，根据第二个元素正向排序，
	* 往往能够简化解题过程。
	* */


	class Solution {
		public int[][] reconstructQueue(int[][] people) {
			Arrays.sort(people, (o1,o2)->{
			return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
		});

//			ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			ArrayList<int[][]> res = new ArrayList<>();

			for (int i = 0; i < people.length; i++) {
				if (people[i][1]<res.size()){
					int[][] toadd = {{
							people[i][0], people[i][1]
					}};
					res.add(people[i][1],toadd);
				}else {
					int[][] toadd = {{
							people[i][0], people[i][1]
					}};
					res.add(toadd);
				}
			}
			for (int i = 0; i < people.length; i++) {
				people[i][0]=res.get(i)[0][0];
				people[i][1]=res.get(i)[0][1];
			}
			return people;
		}
	}
}
