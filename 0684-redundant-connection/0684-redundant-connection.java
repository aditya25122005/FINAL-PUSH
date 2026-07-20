class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU();
        for(int i=1;i<=edges.length;i++){
            dsu.Create(i);
        }
        for(int [] E: edges){
            int A = E[0];
            int B = E[1];
            if(!dsu.Union(A,B)) return new int[]{A,B};
        }
        return new int[]{};
    }
    class DSU{
        class Node{
            int val;
            Node parent;
            int rank;
            public Node(int val,int rank){
                this.val = val;
                this.rank = rank;
            }
        }
        
        private HashMap<Integer,Node> map = new HashMap<>();

        public void Create(int x){
            Node nn = new Node(x,0);
            nn.parent = nn;
            map.put(x, nn);
        }
        public Node Find(int x){
            Node nn = map.get(x);
            Node par = find(nn);

            return par;
        }
        private Node find(Node x){
            if(x.parent == x){
                return x;
            }
            Node nn = find (x.parent);
            x.parent = nn;

            return nn;
        }
        public boolean Union(int x, int y){
            Node nn1 = map.get(x);
            Node nn2 = map.get(y);

            Node RE1 = Find(x);
            Node RE2 = Find(y);

            if(RE1 == RE2){
                return false;
            }
            else{
                if(RE1.rank == RE2.rank){
                    RE1.parent = RE2;
                    RE2.rank++;
                }
                else if(RE1.rank<RE2.rank){
                    RE1.parent = RE2;
                }
                else{
                    RE2.parent = RE1;
                }
            }
            return true;
        }
    }
}