class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int [] nsi = new int[n];
        int [] psi = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psi[i] = -1;
            }
            else{
                psi[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsi[i] = n;
            }
            else{
                nsi[i] = st.peek();
            }
            st.push(i);
        }
        int mod = 1000000007;
        long sum = (long)0;
        for(int i=0;i<n;i++){
            sum = (sum + (long)((long)arr[i]*(long)(i-psi[i])*(long)(nsi[i]-i))%mod)%mod;
        }
        return (int)(sum%mod);
    }
}