package 中等题;

import org.junit.Test;

import javax.swing.*;
import java.util.*;

public class Q60_第k个排列 {
    /*给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"*/


    //答案，回溯   +  剪枝
    /*所求排列 一定在叶子结点处得到，进入每一个分支，可以根据已经选定的数的个数，进而计算还未选定的数的个数，然后计算阶乘，就知道这一个分支的 叶子结点 的个数：
如果 kk 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫「剪枝」；
如果 kk 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。*/
    class Solution{
        private boolean[] used;
        private int[] factorial;

        private int n;
        private int k;

        public String getPermutation(int n, int k) {
            this.k=k;
            this.n=n;
            calculateFactorial(n);

            used = new boolean[n+1];
            Arrays.fill(used,false);

            StringBuilder path = new StringBuilder();
            dfs(0,path);
            return path.toString();
        }

        private void dfs(int index, StringBuilder path) {
            if (index==n) return;

            int cnt= factorial[n-1-index];
            for (int i = 1; i <=n ; i++) {
                if (used[i]) continue;
                if (cnt<k){
                    k-=cnt;
                    continue;
                }

                path.append(i);
                used[i]=true;
                dfs(index+1,path);

                return;

            }
        }





        private void calculateFactorial(int n) {
            factorial = new int[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
        }








    }




    // 我想用回溯记录所有的排列组合然后排序输出对应位置，但是再改就有点小麻烦；懒得改了
    class Solution2 {
    @Test
        public void test(){
        System.out.println(getPermutation(3, 3));
    }



        public String getPermutation(int n, int k) {
            ArrayList<String> list = new ArrayList<>();
            Set set = new LinkedHashSet<String>();
            process(1,n,new StringBuilder(),list,set);
            System.out.println(list);
            return list.get(k);
        }
        public void  process(int cur,int n,StringBuilder sb,List<String> list,Set<Integer> set){
            if (sb.length()==n) {
                list.add(sb.toString());
                return;
            }
            for (int i = 1; i <=n ; i++) {
                if (set.contains(i)) continue;

                set.add(i);
                sb.append(i);
                process(i+1,n,sb,list,set);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}

























