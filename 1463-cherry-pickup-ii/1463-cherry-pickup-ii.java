class Solution {
    int [][][] dp;
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int [][] A:dp){
            for(int [] B:A){
                Arrays.fill(B,-1);
            }
        }
        return Solve(grid,0,0,grid[0].length-1);
    }
    public int Solve(int [][] grid, int cr, int c1, int c2){
        if(cr>=grid.length || c1<0 || c1>=grid[0].length || c2<0 || c2>= grid[0].length){
            return Integer.MIN_VALUE;
        }
        if(cr==grid.length-1){
            return c1==c2? grid[cr][c1] : grid[cr][c1]+grid[cr][c2];
        }
        if(dp[cr][c1][c2]!=-1) return dp[cr][c1][c2];
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int F = 0;
        int G = 0;
        int H = 0;
        int I = 0;
        int S1 = 0;

        if(c1==c2){
            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1+1,c2+1));
            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1+1,c2-1));
            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1+1,c2));

            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1-1,c2+1));
            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1-1,c2-1));
            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1-1,c2));

            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1,c2+1));
            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1,c2-1));
            S1 = Math.max(S1,grid[cr][c1]+Solve(grid,cr+1,c1,c2));
            
        }
        else{
        A = grid[cr][c1]+ grid[cr][c2] + Solve(grid,cr+1,c1+1,c2+1);
        B = grid[cr][c1]+ grid[cr][c2] + Solve(grid,cr+1,c1+1,c2-1);
        C = grid[cr][c1]+ grid[cr][c2] + Solve(grid,cr+1,c1+1,c2);

        D = grid[cr][c1]+ grid[cr][c2]+ Solve(grid,cr+1,c1-1,c2+1);
        E = grid[cr][c1]+ grid[cr][c2]+ Solve(grid,cr+1,c1-1,c2-1);
        F = grid[cr][c1]+ grid[cr][c2]+ Solve(grid,cr+1,c1-1,c2);

        G = grid[cr][c1]+ grid[cr][c2]+ Solve(grid,cr+1,c1,c2+1);
        H = grid[cr][c1]+ grid[cr][c2]+ Solve(grid,cr+1,c1,c2-1);
        I = grid[cr][c1]+ grid[cr][c2]+ Solve(grid,cr+1,c1,c2);
        }
        return dp[cr][c1][c2] = Math.max(A,Math.max(B,Math.max(C,Math.max(D,Math.max(E,Math.max(F,Math.max(G,Math.max(H,Math.max(I,S1)))))))));

    }
}