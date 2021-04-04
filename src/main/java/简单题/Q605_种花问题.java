package 简单题;

public class Q605_种花问题 {
	/*假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
	可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:

输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
*/
	//进行简单的优化
	class Solution2 {
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
			for (int i = 0; i < flowerbed.length; i++) {
				if (n==0){
				    return true;
				}
				if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
					flowerbed[i] = 1;
					n--;
			}
			}
			return n==0;
		}
	}

	//简单的贪心
	class Solution {
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
			if(flowerbed.length==1){
				if(n==0) return true;
				else if(flowerbed[0]==0) return true;
				return false;
			}
			for (int i = 0; i < flowerbed.length; i++) {
				if(n==0) return true;

				if (i==0&&flowerbed[i+1]==0&&flowerbed[i]==0){
					flowerbed[0]=1;
					n--;
				}else if (i==flowerbed.length-1&&flowerbed[i-1]==0&&flowerbed[i]==0){
					flowerbed[i]=1;
					n--;
				}else if (i!=0&&i!=flowerbed.length-1&&flowerbed[i-1]==0&&flowerbed[i+1]==0&&flowerbed[i]==0){
					flowerbed[i]=1;
					n--;
				}
			}
			return n==0;
		}
	}
}
