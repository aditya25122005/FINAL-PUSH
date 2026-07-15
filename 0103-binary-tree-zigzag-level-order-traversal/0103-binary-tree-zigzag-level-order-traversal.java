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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        if(root==null) return ll;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode rm = q.poll();
                inner.add(rm.val);
                if(rm.left!=null) q.add(rm.left);
                if(rm.right!=null) q.add(rm.right);
            }
            if(idx%2==1) Collections.reverse(inner);
            ll.add(new ArrayList<>(inner));
            idx++;
        }
        return ll;
    }
}