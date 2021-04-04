package JZOffer;

import java.util.LinkedList;

public class JZ62_圆圈中最后剩下的数字 {
/*0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
求出这个圆圈里剩下的最后一个数字。
例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
。*/
class Solution {

	//思路1：建一个链表(Arraylist其实是更快一点的，因为拷贝的内存空间时连续的，勉强能过)，保存0-n的所有数字，每次变换位置然后删除这个位置的数字，注意越界判断；最后剩下的即答案
		//超时 ： 经验是如果 n<10^5,那么 O(n^2)的解法耗时大概是几秒左右

	public int lastRemaining(int n, int m) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int pos=0;

		while (list.size()>1){
			if (pos+m>list.size()){
			    pos=(pos+m)%list.size()-1;
				if(pos<0) pos=list.size()-1;
			}else {
				pos+=m-1;
			}
			list.remove(pos);
		}
		return list.get(0);
	}
}
}
