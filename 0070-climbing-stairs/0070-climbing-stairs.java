class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int prev_1= 1;
        int prev_2= 2;

        for(int i =3; i<= n; i++){

            int temp = prev_1 + prev_2;
            prev_1 = prev_2;
            prev_2 = temp;
        }
        return prev_2;
    }
}