class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    DFS(i,j,grid);
                }
            }
        }
        return count;
    }
    public static void DFS(int cr, int cc, char[][] grid){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || grid[cr][cc]=='0'){
            return;
        }
        grid[cr][cc] = '0';
        DFS(cr-1,cc,grid);
        DFS(cr+1,cc,grid);
        DFS(cr,cc-1,grid);
        DFS(cr,cc+1,grid);
    }
}