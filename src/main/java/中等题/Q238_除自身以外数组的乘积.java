package 中等题;


public class Q238_除自身以外数组的乘积 {






    //左右乘积列表，用两个数组把 给定索引i 一个放 对应的左边的所有元素乘积 一个放右边的；
    class Solution1 {
        public int[] productExceptSelf(int[] nums) {
            int[] l = new int[nums.length];
            int[] r = new int[nums.length];
            int[] a = new int[nums.length];

            l[0]=1;
            r[nums.length-1]=1;
            for (int i = 1; i <nums.length ; i++) {
                l[i] = l[i-1]*nums[i-1];
            }
            for (int i = nums.length-2; i >=0 ; i--) {
                r[i] = r[i+1]*nums[i+1];
            }
            for (int i = 0; i <nums.length ; i++) {
                a[i] = l[i] *r[i];
            }
            return a;
        }
    }

    //暴力解法
    //还可以先将所有的元素乘起来，然后遍历时除以对应的那个元素，但是要求用例不能有0
    class Solution2 {
        public int[] productExceptSelf(int[] nums) {
            int[] a = new int[nums.length];
            int sum;
            for (int i = 0; i <nums.length ; i++) {
                a[i] = getSum(i,nums);
            }
            return a;
        }
        public int getSum(int n,int nums[]){
            int sum=1;
            for (int i = 0; i <nums.length ; i++) {
                if (i!=n){
                    sum*=nums[i];
                }
            }
            return sum;
        }
    }
}
