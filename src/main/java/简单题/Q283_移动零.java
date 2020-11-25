package 简单题;

import org.junit.Test;

public class Q283_移动零 {
//    class Solution {
        int nums[] = {0,0,1};

//        @Test
//        public void test(){
//            moveZeroes3(nums);
//            for (int a: nums
//                 ) {
//                System.out.print(a+" ");
//            }
//        }

        //错的
        public void moveZeroes(int[] nums) {
            for (int i = 0; i <nums.length; i++) {
                if (nums[i]==0){
                    for(int j=i;j<nums.length-1;j++){
                        nums[j]=nums[j+1];
                    }
                    nums[nums.length-1]=0;
                }
            }
        }


        /*双指针
        * 我们创建两个指针i和j，第一次遍历的时候指针j用来记录当前有多少非0元素。即遍历的时候每遇到
        * 一个非0元素就将其往数组左边挪，第一次遍历完后，j指针的下标就指向了最后一个非0元素下标。
        第二次遍历的时候，起始位置就从j开始到结束，将剩下的这段区域内的元素全部置为0。
        */

        public void moveZeroes2(int[] nums) {
            if (nums==null) return;

            int j=0;
            for (int i = 0;  i<nums.length ; i++) {
                if (nums[i]!=0){
                    nums[j++] = nums[i];
                }
            }
            for (int i = j; i < nums.length; i++) {
                nums[i]=0;
            }
        }


        /*这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，
        然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
        这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
        这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，
        我们就交换nums[i]和nums[j]
        */
        public void moveZeroes3(int[] nums) {
            if (nums==null) return;

            int j=0;
            int temp;
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]!=0){
                    if (i>j){
                       nums[j]=nums[i];
                       nums[i]=0;
                    }
                    j++;
                }
            }




        }

}
