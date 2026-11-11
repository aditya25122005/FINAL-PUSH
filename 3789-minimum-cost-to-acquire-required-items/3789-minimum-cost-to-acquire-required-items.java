class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res=0;
        long effective1=Math.min(costBoth,cost1);
        long effective2=Math.min(costBoth,cost2);

        if(costBoth<effective1+effective2){
            int minNeed=Math.min(need1,need2);
            res+= (long)costBoth*minNeed;

            need1-=minNeed;
            need2-=minNeed;
        }
        res+= (long) effective1*need1;
        res+= (long) effective2*need2;
        return res;
    }
}