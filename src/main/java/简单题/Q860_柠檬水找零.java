package 简单题;

import org.junit.Test;

public class Q860_柠檬水找零 {
	/**
	 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
	 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
	 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
	 * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
	 * 注意，一开始你手头没有任何零钱。
	 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
	 * 示例 1：
	 * 输入：[5,5,5,10,20]
	 * 输出：true
	 * 解释：
	 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
	 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
	 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
	 * 由于所有客户都得到了正确的找零，所以我们输出 true。
	 */

	//最优解
	class Solution {
		public boolean lemonadeChange(int[] bills) {
			int five = 0, ten = 0;
			for (int bill : bills) {
				if (bill == 5) {
					five++;
				} else if (bill == 10) {
					if (five == 0) {
						return false;
					}
					five--;
					ten++;
				} else {
					if (five > 0 && ten > 0) {
						five--;
						ten--;
					} else if (five >= 3) {
						five -= 3;
					} else {
						return false;
					}
				}
			}
			return true;
		}
	}



	//我自己写的，通过38/45 数据很大的时候不知道为啥会不通过
		class Solution2 {
	public boolean lemonadeChange(int[] bills) {
		int rest = 0;
		int[] m = new int[]{0,0,0};
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				m[0]++;
				rest+=5;
				continue;
			} else if (bills[i] == 10) {
				m[1]++;
			} else {
				m[2]++;
			}

			if (bills[i] - 5 > rest) {
				return false;
			}

			if (!canChange(m,bills[i]-5)){
				return false;
			}

			rest += 5;
		}
		return true;
	}

	public boolean canChange(int[] nums,int tar){
		for (int j = 0; j <= nums[1]; j++) {
			for (int k = 0; k <= nums[0]; k++) {
				if (5 * k + 10 * j == tar) {
					nums[0] = nums[0] - k;
					nums[1] = nums[1] - j;
					if (nums[0]<0||nums[1]<0){
						return false;
					}
					return true;
				}
			}
		}
		return false;
	}
	}

}
