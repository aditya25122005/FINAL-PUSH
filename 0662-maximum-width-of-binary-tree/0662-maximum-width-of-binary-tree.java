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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,1));
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int start = -1;
            int end = -1;
            for(int i=0;i<size;i++){
                pair rm = q.poll();
                
                if(i==0){
                    start = rm.idx;
                }
                if(i==size-1){
                    end = rm.idx;
                    ans = Math.max(ans, end-start+1);
                }
                
                
                if(rm.node.left!=null){
                    q.add(new pair(rm.node.left, rm.idx*2));
                }
                if(rm.node.right!=null){
                    q.add(new pair(rm.node.right,rm.idx*2 +1));
                }
            }
        }
        return ans;
    }
    static class pair{
        TreeNode node;
        int idx;
        public pair(TreeNode node,int idx){
            this.node = node;
            this.idx =idx;
        }
    }
}