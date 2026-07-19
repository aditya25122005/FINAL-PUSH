class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(n==1) return 0;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] E: times){
            int u = E[0];
            int v = E[1];
            int wt = E[2];
            map.get(u).put(v,wt);
        }
        int ans = 0;
        HashSet<Integer> vis = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.dis,b.dis));
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair rm = pq.poll();
            if(vis.contains(rm.vtx)) continue;
            vis.add(rm.vtx);
            ans = Math.max(ans,rm.dis);
            for(int nbrs: map.get(rm.vtx).keySet()){
                if(!vis.contains(nbrs)){
                    int newCost = rm.dis+map.get(rm.vtx).get(nbrs);
                    pq.add(new Pair(nbrs,newCost));
                }
            }
        }
        if(vis.size() !=n) return -1;
        return ans;
    }
    static class Pair{
        int vtx;
        int dis;
        public Pair(int vtx, int dis){
            this.vtx=vtx;
            this.dis = dis;
        }
    }
}