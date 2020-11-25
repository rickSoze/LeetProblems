package 简单题;

public class Q88_合并两个有序数组 {
    /*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    * */


//从要返回的数组末尾开始，使用双指针不停填入最大的；
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
            while (p2 >= 0) {
                if (p1>=0 && nums1[p1] >= nums2[p2]) {
                    nums1[p3--] = nums1[p1--];
                }
               else {
                    nums1[p3--] = nums2[p2--];
                }
            }
        }



        //傻逼
        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i <nums2.length ; i++) {
                for (int j = 0; j < nums1.length; j++) {
                    if (nums2[i]<=nums1[j]){
                        for (int k = m++; k >=j ; k--) {
                            nums1[k] =nums1[k-1];
                        }
                        nums1[j] = nums2[i];
                        j=i;
                        break;
                    }
                }
            }

            
            
        }
    }
}
