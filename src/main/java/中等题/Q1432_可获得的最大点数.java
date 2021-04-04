package 中等题;

import java.util.Arrays;

public class Q1432_可获得的最大点数 {
	/*几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
你的点数就是你拿到手中的所有卡牌的点数之和。
给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
示例 1：
输入：cardPoints = [1,2,3,4,5,6,1], k = 3
输出：12
解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。
最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。*/


	//逆向思维，最后剩下的一定是连续的几个数，因此只要这几个连续的数的和最小，拿走的就是最大的
	//通过一个滑动窗口找出整个序列中连续的、和最小的子序列，再用总和减去这个子序列的和即是答案
	class Solution {
		public int maxScore(int[] cardPoints, int k) {
			int n = cardPoints.length;
			// 滑动窗口大小为 n-k
			int windowSize = n - k;
			// 选前 n-k 个作为初始值
			int sum = 0;
			for (int i = 0; i < windowSize; ++i) {
				sum += cardPoints[i];
			}
			int minSum = sum;
			for (int i = windowSize; i < n; ++i) {
				// 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
				sum += cardPoints[i] - cardPoints[i - windowSize];
				minSum = Math.min(minSum, sum);
			}
			return Arrays.stream(cardPoints).sum() - minSum;
		}
	}

}
