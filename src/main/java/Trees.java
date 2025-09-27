public class Trees {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(34);
        tree.left = null;
        tree.right = new TreeNode(45);
    }
}

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

public class Solution {
    TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();
    int maxHeight = 0;
    boolean check = true;
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> lisi = new ArrayList();
        inOrder(A);
        System.out.println(check);
        return lisi;
    }

    void inOrder(TreeNode A) {
        if (A==null) return;
        if (Math.abs(height(A.left) - height(A.right)) > 1) {
            check = false;
        }
        inOrder(A.left);
        inOrder(A.right);
    }

    int height(TreeNode node) {
        if (node == null) return -1;
        int l = height(node.left);
        int r = height(node.right);
        return 1 + Math.max(l,r);
    }



}

