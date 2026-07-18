class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return GCD(nums[0], nums[nums.length-1]);
    }
    public int GCD(int A, int B){
        if(B==0) return A;
        return GCD(B, A%B);
    }
}