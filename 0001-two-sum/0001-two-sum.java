class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        int curr = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            curr = nums[i];
            if(map.containsKey(target-curr)){
                return new int[]{i, map.get(target-curr)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}