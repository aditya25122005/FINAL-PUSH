class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ll = new ArrayList<>();
        for(int start=1;start<=9;start++){
            generate(low,high,ll,start);
        }
        Collections.sort(ll);
        return ll;

    }
    public static void generate(int lo, int hi,List<Integer> ll, int curr){
        if(curr>hi){
            return;
        }
        if(curr>=lo && curr<=hi){
            ll.add(curr);
        }
        int last = curr%10;
        int add = last+1;
        if(add<10){
            generate(lo,hi,ll,curr*10+add);
        }
    } 
}