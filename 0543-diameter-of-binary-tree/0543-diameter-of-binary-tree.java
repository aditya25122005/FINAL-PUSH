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
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        Solve(root);
        return ans-1;
    }
    static int ans;
    public static int Solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Solve(root.left);
        int right = Solve(root.right);
        ans = Math.max(ans,left+right+1);

        return Math.max(left,right)+1;
    }
}