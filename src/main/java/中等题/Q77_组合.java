package 中等题;

import java.util.ArrayList;
import java.util.List;

public class Q77_组合 {
    class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k<=0||k>n) return res;
        ArrayList<Integer> list = new ArrayList<>();

        process(n,k,1,list);
        return res;
    }

    public void process(int n,int k,int start,List<Integer> list){
        if (list.size()==k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n ; i++) {
            list.add(i);
            process(n,k,i+1,list);
            list.remove(list.size()-1);
        }

    }
}

}
