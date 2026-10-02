class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll = new ArrayList<>();
        Solve(n,"",ll,0,0);
        return ll;
    }
    public static void Solve(int n, String ans, List<String> ll, int open, int close){
        if(open>n || close>open){
            return;
        }
        if(ans.length()==2*n){
            ll.add(ans);
            return;
        }
        Solve(n,ans+"(",ll, open+1, close);
        Solve(n,ans+")",ll,open,close+1);
    }
}