class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int res[] = new int[n];
        
        res[0]=1;

        for(int l = 1; l<n; l++ ){
            res[l] = res[l-1] * nums[l-1];

        }
        int rightProd =1;

        for(int r = n-1; r>=0; r--){
            res[r] = res[r] *rightProd;
            rightProd *=nums[r];
        }
        return res;
    }

}