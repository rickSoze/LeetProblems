package 简单题;

public class Q581_最短无序连续子数组 {
    class Solution {
//也可以先排序，再找到前后位置不正确的两个差距最大的元素的位置；
        public int findUnsortedSubarray(int[] nums) {
            int l = nums.length;
            int r =0;
            for (int i = 0; i <nums.length -1; i++) {
                for (int j = i+1; j<nums.length ;j++){
                    if (nums[i]>nums[j]){
                        l = Math.min(l,i);
                        r = Math.max(j,r);
                    }
                }
            }
            return r-l<0?0:r-l+1;
        }
    }
}
