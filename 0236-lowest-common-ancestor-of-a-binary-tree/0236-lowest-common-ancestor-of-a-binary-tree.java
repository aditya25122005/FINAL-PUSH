/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return Solve(root,p,q);
    }
    public static TreeNode Solve(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p){
            return root;
        }
        if(root==q){
            return root;
        }
        TreeNode left = Solve(root.left,p,q);
        TreeNode right = Solve(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }
        else if(left==null){
            return right;
        }
        return left;
    }
}