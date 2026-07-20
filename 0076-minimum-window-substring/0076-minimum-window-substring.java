class Solution {
    public String minWindow(String s, String t) {
        
        // int [] f1 = new int[52];
        // int [] f2 = new int[52];
        HashMap<Character,Integer> f1 = new HashMap<>();
        HashMap<Character,Integer> f2 = new HashMap<>();
        for(char ch: t.toCharArray()){
            f1.put(ch,f1.getOrDefault(ch,0)+1);
        }
        int ans = Integer.MAX_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        int si = 0;
        int ei = 0;
        int n = s.length();
        while(ei<n){
            char ch = s.charAt(ei);
            f2.put(ch,f2.getOrDefault(ch,0)+1);
            if( (ei-si+1)>=t.length()){
                if(isValid(f1,f2)){
                    if(ans > ei-si+1){
                        ans = ei-si+1;
                        ansStart = si;
                        ansEnd = ei;
                    }
                    while(si<=ei && (!f1.containsKey(s.charAt(si)) || f2.get(s.charAt(si))>f1.get(s.charAt(si)))){
                    f2.put(s.charAt(si), f2.get(s.charAt(si))-1);
                    // if(f2.get(s.charAt(si))==0) f2.remove(s.charAt(si));
                    si++;
                    int currlen = ei-si+1;
                    if(ans>currlen){
                        ans = currlen;
                        ansStart = si;
                        ansEnd = ei;
                    }
                }
                
                }
                
            }
            ei++;

        }
        if(ans==Integer.MAX_VALUE) return "";
        return s.substring(ansStart,ansEnd+1);
        

    }
    public static boolean isValid(HashMap<Character,Integer> f1,HashMap<Character,Integer> f2){
        for(char key: f1.keySet()){
            if(!f2.containsKey(key) || f2.get(key)<f1.get(key)){
                return false;
            }
        }
        return true;
    }
}