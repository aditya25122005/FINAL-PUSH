class Solution {
    public int ladderLength(String begin, String endWord, List<String> wordList) {
        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int curr = 1;
        q.add(begin);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String rm = q.poll();
                if(vis.contains(rm)) continue;
                vis.add(rm);
                if(rm.equals(endWord)) return curr;

                for(String str:wordList){
                    if(isValid(rm,str) && !vis.contains(str)){
                        q.add(str);
                    }
                }
            }
            curr++; 
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