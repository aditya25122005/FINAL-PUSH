class Solution {
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        int [] nsi = new int[n];
        int [] psi = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i= n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
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
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
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
        int ans = 0;
        for(int i=0;i<n;i++){
            int curr = heights[i]*(nsi[i]-psi[i]-1);
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}