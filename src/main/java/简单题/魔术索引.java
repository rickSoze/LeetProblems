package 简单题;

public class 魔术索引 {
    //简单的遍历
    class Solution {
        public int findMagicIndex(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==i) return i;
            }
            return -1;
        }
    }

    //跳跃式的查找 必须是有序数组
    class Solution2 {
        public int findMagicIndex(int[] nums) {
            for(int i=0;i<nums.length; ){
                if(nums[i]==i)
                    return i;
                i=Math.max(nums[i],i+1);
            }
            return -1;
        }
    }
}
