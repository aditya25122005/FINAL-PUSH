class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int [] R ={0,0,1,-1};
        int [] C = {1,-1,0,0};
        while(!q.isEmpty()){
            int [] rm = q.poll();
            int r = rm[0];
            int c = rm[1];
            int t = rm[2];
            for(int i=0;i<4;i++){
                int nr = r+R[i];
                int nc = c+C[i];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    q.add(new int[]{nr,nc,t+1});
                    ans = Math.max(ans,t+1);
                }
            }
            
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
}