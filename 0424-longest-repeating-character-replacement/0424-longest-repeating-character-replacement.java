class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int maxF = 0;
        int si = 0;
        int ei = 0;
        int ans = 1;
        while(ei<n){
            char ch = s.charAt(ei);
            freq[ch-'A']++;
            maxF = Math.max(maxF,freq[ch-'A']);
            while(ei-si+1 - maxF > k){
                freq[s.charAt(si)-'A']--;
                
                si++;
            }
            ans = Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}