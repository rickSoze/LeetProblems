package 数据结构.简单;

import java.util.ArrayList;
import java.util.List;

public class Q257_二叉树的所有路径 {
/*给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。
示例:
输入:
   1
 /   \
2     3
 \
  5
输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
* */
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  //bfs
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root==null) return list;
        process(root,list,new StringBuilder());
        return list;
    }

    public void process(TreeNode root, List<String> list, StringBuilder sb){
        if (root==null) return;
        if (root.left==null && root.right ==null) {
            list.add(sb.toString()+root.val);
        }

            sb.append(root.val +"->");
            int sz = sb.length();
            process(root.left,list,sb);
            process(root.right,list,sb);
//        for (int i = sb.length()-2;i >0 ; i--) {
//            if (sb.charAt(i) == '>') {
//                sb.delete(i + 1, sb.length());
//                break;
//            }
//        }
            sb.delete(sz,sb.length());
        }
    }
}



















