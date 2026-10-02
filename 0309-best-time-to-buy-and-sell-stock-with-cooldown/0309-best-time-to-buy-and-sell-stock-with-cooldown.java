class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return Solve(prices,0,0,dp);
    }
    public static int Solve(int [] prices, int idx, int curr,Integer[][] dp){
        if(idx>=prices.length){
            return 0;
        }
        if(dp[idx][curr]!=null) return dp[idx][curr];
        int A=0;
        int B = 0;
        int C = 0;
        int D = 0;
        if(curr==0){
            A = -prices[idx]+Solve(prices,idx+1,1,dp);
            B = Solve(prices, idx+1,0,dp);
        }
        else{
            C = prices[idx]+Solve(prices,idx+2,0,dp);
            D = Solve(prices,idx+1,1,dp);
        }
        return dp[idx][curr] = Math.max(A,Math.max(B,Math.max(C,D)));
    }
}