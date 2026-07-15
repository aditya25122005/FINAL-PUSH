/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkTree(TreeNode root) {
        return Solve(root);
    }
    public boolean Solve(TreeNode root){
        if(root == null){
            return true;
        }
        int left = 0;
        int right = 0;
        left = root.left==null? left: root.left.val;
        right = root.right==null? right: root.right.val;
        if(root.left!=null || root.right!=null){
            if(left+right != root.val) return false;
        }
        boolean A = Solve(root.left);
        boolean B = Solve(root.right);
        
        return A && B;
    }
}