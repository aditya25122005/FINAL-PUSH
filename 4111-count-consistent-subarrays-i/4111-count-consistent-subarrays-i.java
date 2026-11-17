class Solution {
    public int countConsistent(int[] nums) {
        int c = 0;
        for(int i=0;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            int and = 0;
            for(int j=i;j<nums.length;j++){
                if(j==i){
                    and = nums[i];
                }
                and  = and&nums[j];
                min = Math.min(min,nums[j]);
                if(min==and){
                    c++;
                }
            }
        }
        return c;

    }
}