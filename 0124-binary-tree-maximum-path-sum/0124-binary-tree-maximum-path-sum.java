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
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        Solve(root);
        return ans;
    }
    static int ans;
    public static int Solve(TreeNode root){
        if(root ==  null){
            return 0;
        }
        int left = Solve(root.left);
        int right = Solve(root.right);
        int curr1 = root.val + left + right;
        int curr2 = root.val+ left;
        int curr3 = root.val+ right;
        int curr4 = root.val;
        ans = Math.max(ans,Math.max(curr1,Math.max(curr2,Math.max(curr3,curr4))));
        return Math.max(root.val, root.val+ Math.max(left,right));
    }
}