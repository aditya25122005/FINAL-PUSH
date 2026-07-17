class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> hh = new HashSet<>();
        int curr = 1;
        int ans = 1;
        for(int num: nums){
            hh.add(num);
        }
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(hh.contains(val+1)){
                continue;
            }
            else{
                int target = val-1;
                // hh.remove(val);
                while(hh.contains(target)){
                    hh.remove(target);
                    target--;
                    curr++;
                    
                }
                ans= Math.max(ans,curr);
                curr = 1;
            }
        }
        return ans;
    }
}