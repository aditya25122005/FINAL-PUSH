class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int [] ngi = new int[nums.length];
        int [] pgi = new int[nums.length];
        int [] nsi = new int[nums.length];
        int [] psi = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ngi[i] = n;
            }
            else{
                ngi[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
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

        st.clear();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
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

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pgi[i] = -1;
            }
            else{
                pgi[i] = st.peek();
            }
            st.push(i);
        }
        long minSum = 0;
        for(int i=0;i<n;i++){
            minSum+= (long)nums[i]*(long)(nsi[i]-i)*(long)(i-psi[i]);
        }
        long maxSum = 0;
        for(int i=0;i<n;i++){
            maxSum+= (long)nums[i]*(long)(ngi[i]-i)*(long)(i-pgi[i]);
        }
        return maxSum-minSum;
    }
    /*
    [2,2,2]
    -1,-1,-1 --> PGI
     1,2,3   -->NGI

     -1,-1,-1 --> PSI
     1,2,3 -->NSI

     subarrays
     2,
     2,2,
     2,2,2

     2,
     2,2

     2,
    Maximums
     2*(1)*(1) -->2 (1 subarray)
     2*(2)*(1) -->4 (2 subarray)
     2*(3)*(1) -->6 (3 subarray)

     Minimums
     2*(1)*(1) -->2 (1 subarray)
     2*(2)*(1) -->4 (2 subarray)
     2*(3)*(1) -->6 (3 subarray)

     ans = 0


    */
}