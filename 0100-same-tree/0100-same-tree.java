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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null) return false;
        if(q==null) return false;
        return Solve(p,q);
    }
    public boolean Solve(TreeNode a, TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null) return false;
        if(a.val != b.val) return false;
        boolean first = Solve(a.left,b.left);
        boolean second = Solve(a.right,b.right);

        return first && second;
    }
    
}