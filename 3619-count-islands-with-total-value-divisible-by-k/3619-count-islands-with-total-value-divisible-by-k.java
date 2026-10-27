class Solution {
    public int countIslands(int[][] grid, int k) {
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                    curr = 0;
                    Solve(grid,i,j);
                    if(curr%k==0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    static long curr;
    public static long Solve(int[][] grid, int cr, int cc){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || grid[cr][cc]==0){
            return 0;
        }
        curr+= grid[cr][cc];
        grid[cr][cc] = 0;
        Solve(grid,cr+1,cc);
        Solve(grid,cr,cc+1);
        Solve(grid,cr-1,cc);
        Solve(grid,cr,cc-1);

        return curr;
    }

}