package mid.tree;


import mid.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class KthLargestLevelSum {
    public int kthLargestValue(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> levelNodes = new ArrayList<TreeNode>(queue);
            long sum = 0;
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return 0;
    }



}
