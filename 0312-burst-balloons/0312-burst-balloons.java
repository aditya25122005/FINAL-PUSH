class Solution {
    public int maxCoins(int[] nums) {
        int [] arr = new int[nums.length+2];
        for(int i=1;i<arr.length-1;i++){
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[arr.length-1] =1;
        Integer[][] dp = new Integer[arr.length][arr.length];
        return Solve(arr,1,nums.length,dp);
    }
    public static int Solve(int[] nums, int i, int j,Integer[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            ans = Math.max(ans, Solve(nums,i,k-1,dp)+Solve(nums,k+1,j,dp)+ nums[k]*nums[i-1]*nums[j+1]);
        }
        return dp[i][j] = ans;
    }
}