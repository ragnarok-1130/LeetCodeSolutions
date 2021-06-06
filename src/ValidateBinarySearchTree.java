import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 递归校验左子树全部小于根节点且右子树全部大于根节点
     */
    private boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    /**
     * 中序遍历后判断数组是否递增
     */
    public boolean isValidBSTV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTransversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inorderTransversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTransversal(root.left, list);
        }
        list.add(root.val);

        if (root.right != null) {
            inorderTransversal(root.right, list);
        }
    }
}
