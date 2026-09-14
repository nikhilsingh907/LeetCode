class Solution {
    public int maxSubArray(int[] nums) {
        int sum =0;
        int maxSum =nums[0];

        for(int n: nums){

            sum = Math.max(n, sum+n);
            maxSum =Math.max(sum , maxSum);
        }
        
        return maxSum;
    }


}