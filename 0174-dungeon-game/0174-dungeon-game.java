class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int [][] dp = new int[dungeon.length][dungeon[0].length];
        for(int []A: dp){
            Arrays.fill(A,-1);
        }
        return Solve(dungeon,0,0,dp);
    }
    public static int Solve(int [][] dungeon, int cr, int cc, int[][] dp){
        if(cr>=dungeon.length || cc>=dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc]!=-1) return dp[cr][cc];
        int A = Solve(dungeon,cr+1,cc,dp);
        int B = Solve(dungeon,cr,cc+1,dp);
        int health = Math.min(A,B);
        if(health== Integer.MAX_VALUE){
            health = 1;
        }
        return dp[cr][cc] = Math.max(1,health - dungeon[cr][cc]);
    }
}