class Solution {
    public boolean canFinish(int num, int[][] pre) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<num;i++){
            map.put(i, new ArrayList<>());

        }
        int [] in = new int[num];
        for(int [] E: pre){
            int u = E[0];
            int v = E[1];
            in[u]++;
            map.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int rm = q.poll();
            cnt++;
            for(int nbrs: map.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        return cnt==num;
    }
}