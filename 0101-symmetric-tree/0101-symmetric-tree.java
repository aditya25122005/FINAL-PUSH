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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return Solve(root.left,root.right);
        
    }
    public static boolean Solve(TreeNode A, TreeNode B){
        if(A==null && B==null){
            return true;
        }
        if(A==null || B ==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        boolean first = Solve(A.left,B.right);
        boolean second = Solve(A.right,B.left);

        return first && second;
    }
}