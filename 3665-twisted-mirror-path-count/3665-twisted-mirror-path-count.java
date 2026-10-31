class Solution {
    static int mod;
    public int uniquePaths(int[][] grid) {
        mod = 1000000007;
        Integer[][][] dp = new Integer[grid.length][grid[0].length][2];
        return Solve(grid,0,0,0,dp);
    }
    // 0=> down 1=>right
    public static int Solve(int [][] grid, int cr, int cc, int dir,Integer[][][] dp){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length){
            return 0;
        }
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return 1;
        }
        if(dp[cr][cc][dir]!=null) return dp[cr][cc][dir];
        int A = 0;
        int B = 0;
        int C = 0;
        if(grid[cr][cc]==1){
            if(dir==0){
                A = Solve(grid,cr,cc+1,1,dp);
            }
            else{
                A = Solve(grid,cr+1,cc,0,dp);
            }
        }
        else{
            B = Solve(grid,cr+1,cc,0,dp);
            C = Solve(grid,cr,cc+1,1,dp);
        }
        return dp[cr][cc][dir]=  (A+B+C)%mod;
    }
}