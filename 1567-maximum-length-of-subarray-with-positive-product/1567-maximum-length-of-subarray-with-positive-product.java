class Solution {
    public int getMaxLen(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        int negative = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                ll.add(nums[i]);
                if (nums[i] < 0) {
                    negative++;
                }
            } else {
                if (ll.isEmpty())
                    continue;
                if (negative % 2 == 0)
                    res = Math.max(res, ll.size());
                else {
                    int fidx = -1;
                    for (int j = 0; j < ll.size(); j++) {
                        if (ll.get(j) < 0) {
                            fidx = j;
                            break;
                        }
                    }
                    res = Math.max(res, ll.size() - fidx - 1);
                    int lidx = -1;
                    for (int j = ll.size() - 1; j >= 0; j--) {
                        if (ll.get(j) < 0) {
                            lidx = j;
                            break;
                        }
                    }
                    res = Math.max(res, lidx);
                }
                negative = 0;
                ll = new ArrayList<>();

            }
        }

        if (negative % 2 == 0)
            res = Math.max(res, ll.size());
        else {
            int fidx = -1;
            for (int j = 0; j < ll.size(); j++) {
                if (ll.get(j) < 0) {
                    fidx = j;
                    break;
                }
            }
            res = Math.max(res, ll.size() - fidx - 1);
            int lidx = -1;
            for (int j = ll.size() - 1; j >= 0; j--) {
                if (ll.get(j) < 0) {
                    lidx = j;
                    break;
                }
            }
            res = Math.max(res, lidx);
        }
        negative = 0;
        ll = new ArrayList<>();
        return res;
    }
}