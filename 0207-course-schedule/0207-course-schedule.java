class Solution {
    public boolean canFinish(int num, int[][] pre) {
        // bi --> ai
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int [] in = new int[num];
        for(int i=0;i<num;i++){
            map.put(i, new ArrayList<>());
        }
        for(int [] A: pre){
            int u = A[0];
            int v = A[1];
            map.get(v).add(u);
            in[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int pop = 0;
        while(!q.isEmpty()){
            int rm = q.poll();
            pop++;
            for(int nbrs: map.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        return pop == num;
    }
}