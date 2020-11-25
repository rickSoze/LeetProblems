package 简单题;

import java.util.*;

public class Q1122_数组的相对排序 {
    /*给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
示例：
输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
*/

    //牛逼易懂的解法
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] nums = new int[1001];
            int[] res = new int[arr1.length];
            //遍历arr1,统计每个元素的数量
            for (int i : arr1) {
                nums[i]++;
            }
            //遍历arr2,处理arr2中出现的元素
            int index = 0;
            for (int i : arr2) {
                while (nums[i]>0){
                    res[index++] = i;
                    nums[i]--;
                }
            }
            //遍历nums,处理剩下arr2中未出现的元素
            for (int i = 0; i < nums.length; i++) {
                while (nums[i]>0){
                    res[index++] = i;
                    nums[i]--;
                }
            }
            return res;
        }
    }




    //自己做的，很憨批
    class Solution2 {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> map = new TreeMap<>();


            for (int a :
                    arr1) {
                if (map.get(a) == null) {
                    map.put(a, 1);
                } else map.put(a, map.get(a) + 1);
            }

            int[] res = new int[arr1.length];

            int pos=0;
            for (int i = 0; i < arr2.length; i++) {
                Arrays.fill(res,pos,pos+map.get(arr2[i]),arr2[i]);
                pos+=map.get(arr2[i]);
                map.remove(arr2[i]);
            }

            for (Integer integer : map.keySet()) {
                Arrays.fill(res,pos,pos+map.get(integer),integer);
                pos+=map.get(integer);
            }
            return res;
        }
    }
}
