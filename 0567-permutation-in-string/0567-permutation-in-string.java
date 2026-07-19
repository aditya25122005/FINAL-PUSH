class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] f1 = new int[26];
        for(char ch: s1.toCharArray()){
            f1[ch-'a']++;
        }
        int [] f2 = new int[26];
        // for(char ch: s2.toCharArray()){
        //     f2[ch-'a']++;
        // }
        int si = 0;
        int ei = 0;
        while(ei<s2.length()){
            char ch = s2.charAt(ei);
            f2[ch-'a']++;
            if(ei-si+1==s1.length() && isSame(f1,f2)){
                return true;
            }
            else{
                if(ei-si+1==s1.length()){
                    f2[s2.charAt(si)-'a']--;
                    si++;
                }
            }
            ei++;
        }
        return false;
    }
    public static boolean isSame(int [] f1, int[] f2){
        // String s1 = String.valueOf(f1);
        // String s2 = String.valueOf(f2);
        // System.out.println(s1+" --- "+s2);
        // return s1.equals(s2);
        for(int i=0;i<26;i++){
            if(f1[i]!=f2[i]) return false;
        }
        return true;
    }
}