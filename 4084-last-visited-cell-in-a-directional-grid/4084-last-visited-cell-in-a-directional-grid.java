class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        last = new int[2];
        last[0]=0;
        last[1]=0;
        Solve(0,0,grid);
        System.out.println(grid[0][0]);
        return last;
    }
    static int[] last;
    public static void Solve(int cr, int cc, char[][] grid){
        if(cr<0 || cc<0 || cr>=grid.length || cc>=grid[0].length || grid[cr][cc]=='X'){
            return;
        }
        char ch = grid[cr][cc];
        grid[cr][cc]='X';
        last[0]=cr;
        last[1]=cc;
        if(ch=='R'){
            Solve(cr,cc+1,grid);
        }
        else if(ch=='L'){
            Solve(cr,cc-1,grid);
        }
        else if(ch=='U'){
            Solve(cr-1,cc,grid);
        }
        else if(ch=='D'){
            Solve(cr+1,cc,grid);
        }
        
    }
}