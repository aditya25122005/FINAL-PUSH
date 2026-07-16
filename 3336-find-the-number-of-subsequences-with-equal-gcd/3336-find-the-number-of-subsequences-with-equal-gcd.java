class Solution {
    public int subsequencePairCount(int[] nums) {
        int max=0;
        for(int num: nums) max= Math.max(max,num);
        long[][][] dp = new long[max+1][max+1][nums.length];
        for(long [][] A: dp){
            for(long [] B: A){
                Arrays.fill(B,-1);
            }
        }
        int [][] gcdDP = new int[max+1][max+1];
        for(int [] A: gcdDP){
            Arrays.fill(A,-1);
        }

        long ans = Solve(0, 0, 0,nums,dp,gcdDP);
        return (int)(ans%1000000007);
    }
    public  long Solve(int gcd1, int gcd2, int idx, int [] nums,long[][][] dp,
     int[][] gcdDP){
        if(idx==nums.length){
            if((gcd1==gcd2) && gcd1!=0 && gcd2!=0) return 1;
            return 0;
        }

        if(dp[gcd1][gcd2][idx]!=-1) return dp[gcd1][gcd2][idx];
        long op1 = 0;
        long op2 = 0;
        if(gcdDP[gcd1][nums[idx]] !=-1){
            op1 = Solve(gcdDP[gcd1][nums[idx]] , gcd2,idx+1,nums,dp,gcdDP);
        }
        else{
            int newGCD = GCD(gcd1,nums[idx]);
            op1 = Solve(newGCD,gcd2,idx+1,nums,dp,gcdDP);
            gcdDP[gcd1][nums[idx]] = newGCD;
        }

        if(gcdDP[gcd2][nums[idx]] !=-1){
            op2 = Solve(gcd1, gcdDP[gcd2][nums[idx]],idx+1,nums,dp,gcdDP);
        }
        else{
            int newGCD = GCD(gcd2,nums[idx]);
            op2 = Solve(gcd1,newGCD,idx+1,nums,dp,gcdDP);
            gcdDP[gcd2][nums[idx]] = newGCD;
        }
        long op3 = Solve(gcd1,gcd2,idx+1,nums,dp,gcdDP);
        long res = (op1+op2)%1000000007;
        res = (res+op3)%1000000007;
        dp[gcd1][gcd2][idx] = res;  
        return res;
    }
    public int GCD(int A, int B){
        if(B==0) return A;
        return GCD(B, A%B);
    }
}