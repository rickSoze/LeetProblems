package 简单题;

public class Q922_按奇偶排序数组 {
    /*给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。

示例：
输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
*/
    class Solution2 {
        public int[] sortArrayByParityII(int[] A) {
            int p1 = 0, p2 = 1;

            int[] res = new int[A.length];

            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 == 0) {
                    res[p1] = A[i];
                    p1 += 2;
                } else {
                    res[p2] = A[i];
                    p2 += 2;
                }
            }
            return res;
        }
    }


    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int p1 = 0, p2 = 0;

            while (p1 < A.length && p2<A.length) {
                if (p1 % 2 == 0 && A[p1] % 2 == 1) {
                    while (!(p2 % 2 == 1 && A[p2] % 2 == 0)) p2++;

                    int tmp = A[p1];
                    A[p1] = A[p2];
                    A[p2] = tmp;
                }else if (p1%2==1 && A[p1]%2==0){
                    while (!(p2 % 2 == 0 && A[p2] % 2 == 1)) p2++;

                    int tmp = A[p1];
                    A[p1] = A[p2];
                    A[p2] = tmp;
                }
                else  p1++;
            }
            return A;
        }
    }
}
