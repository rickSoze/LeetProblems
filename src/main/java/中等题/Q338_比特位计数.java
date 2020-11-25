package 中等题;

public class Q338_比特位计数 {
//    @Test
//    public void test(){
//        for (int i : countBits(6)) {
//            System.out.print(i);
//        }
//        System.out.println();
//        for (int i : countBits(7)) {
//            System.out.print(i);
//        }
//        System.out.println();
//        for (int i : countBits(8)) {
//            System.out.print(i);
//        }
//
//    }

    class Solution {
        public int[] countBits(int num) {
            int[] nums = new int[num + 1];
            for (int i = 0; i <=num ; i++) {
                nums[i]  = getCount(i);
            }
            return nums;
        }

        public int getCount(int n) {
            int dis = 0;
            while (n != 0) {
                if ((n & 1) % 2 == 1) {
                    dis++;
                }
                n = n >> 1;
            }
            return dis;
        }
    }
}
