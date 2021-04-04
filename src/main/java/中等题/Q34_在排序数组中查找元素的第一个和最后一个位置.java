package 中等题;

import org.junit.Test;

public class Q34_在排序数组中查找元素的第一个和最后一个位置 {
    /*给定一个按照升序排列的整数数组 nums，和一个目标值 target。
    找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
。*/

//二分查找--最优解
    public class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        private int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 小于一定不是解
                if (nums[mid] < target) {
                    // 下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // nums[mid] > target，下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                }
            }

            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    // 下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                } else if (nums[mid] == target){
                    // 下一轮搜索区间是 [mid, right]
                    left = mid;
                } else {
                    // nums[mid] < target，下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    //最优解的优化
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[] {-1, -1};
            res[0] = binarySearch(nums, target, true);
            res[1] = binarySearch(nums, target, false);
            return res;
        }
        //leftOrRight为true找左边界 false找右边界
        public int binarySearch(int[] nums, int target, boolean leftOrRight) {
            int res = -1;
            int left = 0, right = nums.length - 1, mid;
            while(left <= right) {
                mid = left + (right - left) / 2;
                if(target < nums[mid])
                    right = mid - 1;
                else if(target > nums[mid])
                    left = mid + 1;
                else {
                    res = mid;
                    //处理target == nums[mid]
                    if(leftOrRight)
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
            return res;
        }
    }



//    class Solution {
//        public int[] searchRange(int[] nums, int target) {
//            if (nums.length==1&&target==nums[0])return new int[]{0,0};
//            else if (nums.length==1&&target!=nums[0]) return new int[]{-1,-1};
//
//
//            int pos1=-1;
//            for (int i = 0; i < nums.length; i++) {
//                if ( nums[i]==target ){
//                    if (pos1<0) pos1=i;
//                    int[] res = {pos1, i};
//
//                    if ( i+1 < nums.length && nums[i+1]!=target || i+1==nums.length)
//                    return res;
//                }
//            }
//            return new int[]{-1,-1};
//        }
//    }
}
