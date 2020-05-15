package com.constantine.daily.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 反转二叉树
 *
 * 输入
 *     4
 *    /
 *   2   7
 *  /   /
 * 1  3 6  9
 *
 * 输出
 *    4
 *    /
 *   7   2
 *  /   /
 * 9  6 3  1
 *
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    //递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    //利用队列先进先出
    public TreeNode invertTree3(TreeNode root) {
        TreeNode r = root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return r;
    }

    class TreeNode{
        int value;
        TreeNode left ;
        TreeNode right;
    }

}
