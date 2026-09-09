class Solution {
    public int subarraySum(int[] nums, int k) {

        // HashMap: PrefixSum -> Frequency

       HashMap<Integer,Integer> map = new HashMap<>();
       //put first key:with frequncy 1:0.
       map.put(0,1);
       int count =0;
       int PrefixSum=0;

       //for-each loop
       for(int n : nums){
        PrefixSum += n;

        //constaintnsKey method 
        if(map.containsKey(PrefixSum-k)){
            count += map.get(PrefixSum-k);
        }
       map.put(PrefixSum,map.getOrDefault(PrefixSum,0)+1);
       }
       return count ;

    }
    
}