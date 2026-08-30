class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIndx = -1;
        int maxIndx = -1;

        for(int i = 0; i<n; i++){
            if(nums[i] < min){
                min = nums[i];
                minIndx = i;
            }
            if(nums[i] > max){
                max = nums[i];
                maxIndx = i;
            }
        }
        int left = Math.min(minIndx , maxIndx);
        int right = Math.max(minIndx , maxIndx);
        int fromFront = right + 1;
        int fromBack = n - left;
        int fromBoth = left + 1 +(n - right);
        return Math.min(fromFront, Math.min(fromBack, fromBoth));
    }
}