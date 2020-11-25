package 中等题;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q347_前K个高频元素 {
    /*给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
*/

//    @Test
//    public void test(){
//        topKFrequent(new int[]{1,1,1,2,2,3},2);
//    }


 class Solution2 {
     public int[] topKFrequent(int[] nums, int k) {
         // map+TreeSet好傻逼，居然会拒绝频率相同的元素
         // 还是用Arraylist+Sort
         Map<Integer,Integer>map = new HashMap();
         List<Integer>list = new ArrayList<>();
         for (int i = 0; i <nums.length ; i++) {
             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
             if (list.contains(nums[i])) continue;
             else list.add(nums[i]);

         }



         //这个sort直接通过传入的比较器把map中的值拿出来作比较，值得学习
         Collections.sort(list, new Comparator<Integer>() {
             @Override
             public int compare(Integer o1, Integer o2) {
                 return map.get(o2)-map.get(o1);
             }
         });



         int[]ans = new int[k];
         for (int i = 0; i <k ; i++) {
             ans[i] = list.get(i);
         }
         return ans;
     }
 }

//桶排序
    class Solution3 {
        public int[] topKFrequent(int[] nums, int k) {
            // 统计每个数字出现的次数
            Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
            // 一个数字最多出现 nums.length 次，因此定义一个长度为 nums.length + 1 的数组，freqList[i] 中存储出现次数为 i 的所有数字。
            List<Integer>[] freqList = new List[nums.length + 1];
            for (int i = 0; i < freqList.length; i++) {
                freqList[i] = new ArrayList<>();
            }
            counterMap.forEach((num, freq) -> {
                freqList[freq].add(num);
            });
            // 按照出现频次，从大到小遍历频次数组，构造返回结果。
            int[] res = new int[k];
            int idx = 0;
            for (int freq = freqList.length - 1; freq > 0; freq--) {
                for (int num: freqList[freq]) {
                    res[idx++] = num;
                    if (idx == k) {
                        return res;
                    }
                }
            }
            return res;
        }
    }




    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums.length==1) return new int[]{nums[0]};
            int[] cnt = new int[nums.length];
            for (int i = 0; i <nums.length ; i++) {
                cnt[nums[i]]++;
            }
            int[] res = new int[k];
            Arrays.fill(res,Integer.MIN_VALUE);
            for (int i = 0; i <cnt.length ; i++) {
                int p=getMin(res);
                if (cnt[i]>res[p]) res[p]=i;
            }

            return res;

        }
        public int getMin(int a[]){
            int min = Integer.MAX_VALUE;
            int res=0;
            for (int i = 0; i < a.length; i++) {
                if (a[i]<min) {
                    min = a[i];
                    res =i;
                }
            }
            return res;
        }
    }

}
