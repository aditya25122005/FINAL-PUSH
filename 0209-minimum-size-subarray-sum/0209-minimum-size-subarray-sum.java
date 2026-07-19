class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curr = 0;
        int ans = Integer.MAX_VALUE;
        int si = 0;
        int ei = 0;
        while(ei<nums.length){
            curr+=nums[ei];

            
            if(curr>=target){
                ans = Math.min(ans,ei-si+1);
            }
            while(si<=ei && curr>target){
                curr -= nums[si];
                si++;
                if(curr>=target){
                    ans= Math.min(ans,ei-si+1);
                }
            }
            
            ei++;
        }
        return ans==Integer.MAX_VALUE? 0 : ans;
    }
}