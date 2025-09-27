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
