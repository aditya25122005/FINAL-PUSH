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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return Solve(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode Solve(int[] in, int ilo, int ihi, int [] post, int plo, int phi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        TreeNode nn = new TreeNode(post[phi]);
        int idx = find(in,ilo,ihi,post[phi]);
        int eleOnRight = ihi - idx; // 3 elements
        nn.left = Solve(in,ilo,idx-1,post,plo,phi-eleOnRight-1);// doubt in plo
        nn.right = Solve(in,idx+1,ihi,post, phi-eleOnRight,phi-1);
        return nn;
    }
    public static int find(int[] in, int lo,int hi, int target){
        for(int i=lo;i<=hi;i++){
            if(in[i] == target) return i;
        }
        return -1;
    }
}