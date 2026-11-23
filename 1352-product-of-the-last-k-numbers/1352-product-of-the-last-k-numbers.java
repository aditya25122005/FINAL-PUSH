class ProductOfNumbers {

    List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
     
    }
    
    public void add(int num) {

        if(num==0){
            prefix = new ArrayList<>();
            prefix.add(1);
        }
        else{
            int x = prefix.get(prefix.size()-1) * num;
            prefix.add(x);
        }
        
    }
    
    public int getProduct(int k) {
        int n = prefix.size();
        if(n<=k){
            return 0;
        }
        int a = prefix.get(n-1);
        int b = prefix.get(n-k-1);
        
        return a/b;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */