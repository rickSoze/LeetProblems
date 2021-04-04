package JZOffer;

import org.junit.Test;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.HashSet;
import java.util.Set;

public class JZ61_扑克牌中的顺子 {
	/*从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
	2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
示例1:
输入: [1,2,3,4,5]
输出: True
示例2:
输入: [0,0,1,2,5]
输出: True
*/
	//思路1： 排序，然后看是否递增，注意0即可
	//思路2： 看最大和最小的之间的差距是否在4以内， 注意0的大小和数量、是否有相同的非0数
	//思路3： 一个辅助计数数组，统计给的数字，遍历统计数组，如果>2、中间有间断但是没有0了 都是false  个人觉得思路3比较好，时间复杂度低，实现简单

	//应为明确了数组长度只有 5，因此遍历就是O1，直接使用set然后判断最大最小差距即可
	class Solution {
		public boolean isStraight(int[] nums) {
			int[] cnt = new int[14];
			for (int i = 0; i < nums.length; i++) {
				cnt[nums[i]]++;
			}
			if (cnt[0]==5){
				return true;
			}
			for (int i = 1; i < cnt.length; i++) {
				if (cnt[i]>1){
				    return false;
				}

				if (cnt[i]==1){
					for (int j = i+1; j < cnt.length && j<i+5 ; j++) {
						if (cnt[j]>1){
						    return false;
						}
						if (cnt[j]==0&&cnt[0]<=0){
							return false;
						}else if (cnt[j]==0&&cnt[0]>0){
						    cnt[0]--;
						}
					}
					return true;
				}
			}
			return true;
		}
	}
	//大佬题解：
	class Solution2 {
		public boolean isStraight(int[] nums) {
			Set<Integer> repeat = new HashSet<>();
			int max = 0, min = 14;
			for(int num : nums) {
				if(num == 0) continue; // 跳过大小王
				max = Math.max(max, num); // 最大牌
				min = Math.min(min, num); // 最小牌
				if(repeat.contains(num)) return false; // 若有重复，提前返回 false
				repeat.add(num); // 添加此牌至 Set
			}
			return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
		}
	}
}
