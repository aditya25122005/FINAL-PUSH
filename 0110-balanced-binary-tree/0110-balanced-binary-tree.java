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
    public boolean isBalanced(TreeNode root) {
        res = true;
        Solve(root);
        return res;
    }
    static boolean res;
    public static int Solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Solve(root.left);
        int right = Solve(root.right);
        if(Math.abs(left-right)>1) res = false;

        return Math.max(left,right)+1;

    }
}