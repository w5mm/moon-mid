package mid;



import java.util.HashMap;


public class ReBuildTree {
    int[] post ;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length-1,0, post.length - 1);
        return root;
    }
    public TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = post[postEnd];
        int rootIndex = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        node.left = buildTree(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
        node.right = buildTree(rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);
        return node;
    }
}
