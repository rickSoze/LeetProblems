package 数据结构.中等;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q236_二叉树的最近公共祖先 {
    /*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。


输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

*/


    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
      //DFS递归
/*
终止条件：
当越过叶节点，则直接返回 nullnull ；
当 rootroot 等于 p, qp,q ，则直接返回 rootroot ；
递推工作：
开启递归左子节点，返回值记为 leftleft ；
开启递归右子节点，返回值记为 rightright ；
返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
当 leftleft 为空 ，rightright 不为空 ：p,qp,q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
p,qp,q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 pp（假设为 pp ）；
p,qp,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；
*
*
* class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
}

* */



//记录父节点的信息
    //从p节点自底向上遍历到root，记录每一个被遍历的节点
    //从q节点自底向上遍历，如果遇到一个被记录过的节点，则是共同祖先。

    class Solution {
        Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
        Set<Integer> visited = new HashSet<Integer>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           dfs(root);

           while (p!=null){
               visited.add(p.val);
               p=parent.get(p.val);
           }

           while (q!=null){
               if (visited.contains(q.val)){
                   return q;
               }
               q=parent.get(q.val);
           }
           return null;

        }

        public void dfs(TreeNode root){
            if (root.left!=null){
                parent.put(root.left.val,root);
                dfs(root.left);
            }
            if (root.right!=null){
                parent.put(root.right.val,root);
                dfs(root.right);
            }
        }
    }
}
















