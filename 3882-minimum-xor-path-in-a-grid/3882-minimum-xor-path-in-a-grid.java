class Solution {
    public int minCost(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][1024];
        return Solve(grid,0,0,0,dp);
    }
    public static int Solve(int [][] grid, int cr, int cc, int xor,Integer[][][] dp){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        xor^= grid[cr][cc];
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return xor;
        }
        if(dp[cr][cc][xor]!=null){
            return dp[cr][cc][xor];
        }
        int A = Integer.MAX_VALUE;
        int B = Integer.MAX_VALUE;
        int next1 = Solve(grid,cr+1,cc,xor,dp);
        int next2 = Solve(grid,cr,cc+1,xor,dp);
        if(next1!=Integer.MAX_VALUE){
            A = Math.min(A,next1);
        }
        if(next2!=Integer.MAX_VALUE){
            B = Math.min(B,next2);
        }
        
        return dp[cr][cc][xor] = Math.min(A,B);

    }
}