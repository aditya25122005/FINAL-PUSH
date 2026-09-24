class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            curr = nums[i];
            if(map.containsKey(target-curr)){
                return new int[]{i, map.get(target-curr)};
            }
            map.put(curr,i);
        }
        return new int[]{};
    }
}