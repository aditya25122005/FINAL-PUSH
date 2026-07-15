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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public static TreeNode buildTree(int [] pre, int plo, int phi, int [] in, int ilo, int ihi){
        if(ilo>ihi || plo>phi){
            System.out.println("null");
            return null;
        }
        TreeNode nn = new TreeNode(pre[plo]);
        int idx = find(in,ilo,ihi,pre[plo]);
        int eleOnLeft = idx-ilo+1;
        int eleOnRight = ihi-idx;
        nn.left = buildTree(pre,plo+1,plo+eleOnLeft-1, in,ilo,idx-1);
        nn.right = buildTree(pre,plo+eleOnLeft,phi,in,idx+1,ihi);

        return nn;

    }
    // find idx of root in inorder
    public static int find(int [] in, int ilo, int ihi, int target){
        for(int i=ilo;i<=ihi;i++){
            if(in[i] ==  target){
                return i;
            }
        }
        return -1;
    }
}