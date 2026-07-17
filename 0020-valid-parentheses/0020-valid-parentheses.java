class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='{' || ch=='(' || ch=='['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                boolean res = false;
                if(st.peek()=='{' && ch=='}') {
                    st.pop();
                    res = true;
                }
                else if(st.peek()=='[' && ch==']') {
                    st.pop();
                    res=true;
                }
                else if(st.peek()=='(' && ch==')'){
                    st.pop();
                    res = true;
                } 
                else if(!res) return false;

            }
        }
        return st.isEmpty();
    }
}