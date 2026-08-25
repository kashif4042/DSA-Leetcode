class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        // Put all numbers into the set
        for (int num : nums) {
            set.add(num);
        }

        //checking multiples of k
        int ans = k;

        while (set.contains(ans)) {
            ans += k;
        }

        return ans;
    }
}