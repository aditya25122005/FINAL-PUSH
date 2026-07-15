class Solution {
    public int gcdOfOddEvenSums(int n) {
        int A = 0;
        int B = 0;
        for(int i=1;i<n*2;i+=2){
            A+=i;
        }
        for(int i=2;i<=n*2;i+=2){
            B+=i;
        }
        return GCD(A,B);
    }
    public int GCD(int a, int b){
        if(b==0){
            return a;
        }
        return GCD(b,a%b);
    }
}