package 数据结构.中等;

import java.util.ArrayDeque;

public class Q116_填充每个节点的下一个右侧节点指针 {
    /*给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
    二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
*/
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }




    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }

    class Solution2 {
        public Node connect(Node root) {
            if (root==null) return root;
            ArrayDeque<Node> deque = new ArrayDeque<>();

            deque.offer(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Node node = deque.poll();
                    if (i<size-1)
                    node.next = deque.peek();
                    if (node.left != null) {
                        deque.add(node.left);
                    }
                    if (node.right != null) {
                        deque.add(node.right);
                    }

                }
            }
            return root;
        }
    }
}
