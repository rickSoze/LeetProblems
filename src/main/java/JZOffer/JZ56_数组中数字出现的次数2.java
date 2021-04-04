package JZOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JZ56_数组中数字出现的次数2 {
	/*在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1

限制：
1 <= nums.length <= 10000
1 <= nums[i] < 2^31
*/
	class Solution {
		//思路1：遍历并记录，可以用map来记录 时间复杂度On，空间复杂度On
		//思路2：排序再遍历，时间复杂度nlogn 空间O1记录出现次数即可。
		//最优解全是用位运算的，太麻烦了，不会算了。
		public int singleNumber(int[] nums) {
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int num : nums) {
				Integer integer = map.get(num);
				if (integer == null) {
					map.put(num, 1);
				} else {
					map.put(num, integer + 1);
				}
			}
			for (Integer integer : map.keySet()) {
				if (map.get(integer)==1){
				    return integer;
				}
			}
			return 0;
		}
		//简单优化
		public int singleNumber1(int[] nums) {
			HashMap<Integer, Integer> map = new HashMap<>();

			for (int num : nums) {
				Integer integer = map.get(num);
				if (integer == null) {
					map.put(num, 1);
				} else if (integer==1){
					map.put(num, -1);
				}
			}

			for (Map.Entry<Integer,Integer> e : map.entrySet()) {
				if (e.getValue()==1){
				    return e.getKey();
				}
			}
			return -1;
		}
	}
}
