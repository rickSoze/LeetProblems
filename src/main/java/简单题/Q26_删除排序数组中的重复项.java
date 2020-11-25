package 简单题;

public class Q26_删除排序数组中的重复项 {
    /*
    * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1:
给定数组 nums = [1,1,2],
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
你不需要考虑数组中超出新长度后面的元素。*/

    //双指针
    class Solution {
        public int removeDuplicates(int[] nums) {
            int a=0,b=1;
            int len = nums.length;
            while (b<=len){
                if (nums[a]!=nums[b] &&b-a>1){   //小细节，如果ab两个指针是挨着的，则没必要赋值
                    nums[++a] = nums[b];
                }
                b++;
            }
            return a+1;
        }
    }






    //暴力解法，遇到一样的，直接把后面的所有元素前移
    class Solution1 {
        public int removeDuplicates(int[] nums) {
            if(nums.length <2) return nums.length;
            int l = nums.length;
            for (int i = 0; i <l-1 ;) {
                if (nums[i]==nums[i+1]){

                    for (int j = i; j <l-1 ; j++) {
                        nums[j] = nums[j+1];
                    }
                    l--;
                    if(nums[i]!=nums[i+1]) i++;
                }
            }
            return l;
        }
    }

//        public void move(int[] nums,int start){
//            for (int i = start; i <nums.length-1 ; i++) {
//                nums[i] = nums[i+1];
//            }
//        }
//    }
}
