package mid;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, mid.TreeNode left, mid.TreeNode right) {this.val = val;
        this.left = left;
        this.right = right;
    }
}
