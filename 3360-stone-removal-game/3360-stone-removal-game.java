class Solution {
    public boolean canAliceWin(int n) {
        int turn = 0;
        int curr = 10;
        while(n>=curr){
            n-=curr;
            curr--;
            turn=  turn==0?1:0;
        }
        return turn==1? true: false;

    }
}