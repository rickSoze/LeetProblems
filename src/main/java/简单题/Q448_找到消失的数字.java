package 简单题;

import java.util.ArrayList;
import java.util.List;

public class Q448_找到消失的数字 {

//    @Test
////    public void test() {
////        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
////        System.out.println(findDisappearedNumbers2(nums));
////    }

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> integers = new ArrayList<>();
            int[] a = new int[nums.length+1];
            for (int i = 0; i <nums.length ; i++) {
                a[nums[i]]=1;
            }

            for (int i = 1; i <a.length ; i++) {
               if (a[i]==0) integers.add(i);
            }
            return integers;
        }

        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> ints = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int newIndex = Math.abs(nums[i]) - 1;
                if (nums[newIndex] > 0) nums[newIndex]*=-1;
            }
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]<0){
                    ints.add(i+1);
                }
            }
            return ints;
        }

//        public List<Integer> findDisappearedNumbers2(int[] nums){
//           List<Integer> ints = new ArrayList<>();
//            int temp;
//            int cnt=0;
//            for (int i = 0; i <nums.length ; i++) {
//                if ( nums[nums[cnt]]==nums[cnt] ) cnt++;
//                if (cnt>=nums.length) break;
//                temp = nums[nums[cnt]];
//                nums[nums[cnt]] = nums[cnt];
//                nums[cnt] = temp;
//            }
//
//            for (int i = 0; i <nums.length ; i++) {
//                if (nums[i]==i+1) ints.add(i+1);
//            }
//            return ints;
//
//        }

    }


//    class Solution2 {
//        public List<Integer> findDisappearedNumbers(int[] nums) {
//            List<Integer> integers = new ArrayList<>();
//                int temp;
//            for (int i = 0; i <nums.length ; i++) {
//                temp = nums[nums[i]-1];
//                nums[nums[i]-1] = nums[i];
//                nums[i] = temp;
//            }
//
//            for (int i = 0; i <nums.length ; i++) {
//                if (nums[i]==i+1) integers.add(i+1);
//            }
//            return integers;
//        }
//    }

//}

}
