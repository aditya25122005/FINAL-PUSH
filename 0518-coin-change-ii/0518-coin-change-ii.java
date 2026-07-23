class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int [] A: dp){
            Arrays.fill(A,-1);
        }
        return Solve(coins,0,amount,0,dp);
    }
    public static int Solve(int [] coins, int idx, int target, int curr,int[][] dp){
        if(curr>target){
            return 0;
        }
        if(curr==target){
            return 1;
        }
        if(idx==coins.length){
            return 0;
        }
        if(dp[idx][curr]!=-1) return dp[idx][curr];
        int A = 0;
        if(curr+coins[idx]<=target){
            A = Solve(coins,idx,target,curr+coins[idx],dp);
        }
        int B = Solve(coins,idx+1,target,curr,dp);

        return dp[idx][curr] = A+B;
    }

}