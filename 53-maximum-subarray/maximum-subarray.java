class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            //Step 1: Sum create karna hai
            sum = sum + nums[i];
            //Step 2: maxi update karna hai
            maxi = Math.max(sum,maxi);
            //Step 3: sum check karna hai for negative value
            if(sum < 0){
                sum = 0;
            }
        }
        // return max value
        return maxi;
        
    }
}