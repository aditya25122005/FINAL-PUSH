class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int minSum = Integer.MAX_VALUE;
        // find out the subarray with n-k integers having min Sum
        int curr = 0;
        for(int i=0;i<n-k;i++){
            curr+= arr[i];
        }
        int win = n-k;
        minSum = Math.min(minSum,curr);
        for(int i=n-k;i<arr.length;i++){
            curr+=arr[i];
            curr -= arr[i-win];
            minSum = Math.min(minSum,curr);
        }
        int total = 0;
        for(int num:arr){
            total+= num;
        }
        return total-minSum;
        
        // Integer[][][] dp = new Integer[n][n][k+1];
        // return Solve(cardPoints,k,0,cardPoints.length-1,dp);
    }
    public static int Solve(int [] arr, int k, int i, int j,Integer[][][] dp){
        if(i>j){
            return 0;
        }
        if(k<=0){
            return 0;
        }
        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        int A =arr[i]+Solve(arr,k-1,i+1,j,dp);
        int B = arr[j]+Solve(arr,k-1,i,j-1,dp);

        return dp[i][j][k] = Math.max(A,B);
    }
}