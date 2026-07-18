class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int si = 0;
        int ei = 0;
        int maxF = 0;
        int ans = 0;
        while(ei<s.length()){
            char ch = s.charAt(ei);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            maxF = Math.max(maxF,map.get(ch));
            while(ei-si+1 - maxF >k){
                map.put(s.charAt(si), map.get(s.charAt(si))-1);
                si++;
            }
            ans = Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}