package 中等题;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Q22_括号生成 {
    /*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
*/

    /*
    采用回溯的方法，终止的条件是所给的括号全部用完，这时把已有的组合添加到返回的集合中
    通过对左右括号数量的比较判断是否需要剪枝；如果左括号数大于右括号数，则剪枝
    * */
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n==0) return null;
            List<String> res = new ArrayList<>();
            StringBuilder bs = new StringBuilder();
            process(bs,n,n,res);
            return res;
        }

        public void process(StringBuilder sb,int l,int r,List<String> res){
            if (l==0&r==0){
                res.add(sb.toString());
                return;
            }

            if (l>r) return;
            if (l>0){
                sb.append("(");
                process(sb,l-1,r,res);
                sb.deleteCharAt(sb.length()-1);
            }
            if (r>0){
                sb.append(")");
                process(sb,l,r-1,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }


}
