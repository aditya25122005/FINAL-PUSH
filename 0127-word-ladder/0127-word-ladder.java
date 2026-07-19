class Solution {
    public int ladderLength(String begin, String endWord, List<String> wordList) {
        HashSet<String> vis = new HashSet<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->Integer.compare(a.dis,b.dis));
        q.add(new Pair(begin,1));
        while(!q.isEmpty()){
            Pair rm = q.poll();
            if(vis.contains(rm.s)) continue;
            vis.add(rm.s);
            if(rm.s.equals(endWord)){
                return rm.dis;
            }
            for(String str:wordList){
                if(isValid(rm.s,str) && !vis.contains(str)){
                    q.add(new Pair(str,rm.dis+1));
                }
            }
        }
        return 0;
    }
    public boolean isValid(String s1, String s2){
        int diff=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if(diff>1){
                    return false;
                }
            }
        }
        return true;
    }
    static class Pair{
        String s;
        int dis;
        public Pair(String s, int dis){
            this.s = s;
            this.dis = dis;
        }
    }
}