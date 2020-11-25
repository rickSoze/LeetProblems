package 简单题;

public class Q1480_一维数组的动态和 {

//    //不创建保存变量的另一种方法
//    class Solution {
//        public int[] runningSum(int[] nums) {
//            int total = 0;
//            for (int i = 0; i < nums.length; i++) {
//                total = total  + nums[i];
//                nums[i] = total;
//            }
//            return nums;
//        }
//    }
    //直接通过数组本身来进行求和
    class Solution2 {
        public int[] runningSum(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            return nums;
        }
    }



    //通过保存之前每个元素的和，然后赋值给新的数组
    class Solution1 {
        public int[] runningSum(int[] nums) {
            int[] answer = new int[nums.length];
            int sum=0;
            for (int i = 0; i <nums.length ; i++) {
                sum+=nums[i];
                answer[i]=sum;
            }
            return answer;
        }
    }
}
