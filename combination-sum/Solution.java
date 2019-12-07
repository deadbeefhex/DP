class Solution{


    // Combination sum,
    // Given the target value N and an array of numbers, count the ways
    // to write N as a sum of those numbers.

    // Example:
    // N = 4 -> target value/sum
    // allowed_numbers={1,2,3}
    // there is 7 different ways to denote N as a sum of numbers using allowed_numbers
    // 1+1+1+1, 1+1+2, 1+2+1, 1+3, 2+1+1, 2+2, 3+1
    // as shown above, repition is allowed and the order also matters.
    
    //--------------------------------------------------
    // Solution:
    // It helps to think about DP as 'What is important so far?'
    // i.e. what we need to know when we are at some position?
    // So let's take            1+2+1 into further consideration.
    // lets assume we are here      ^ (last number of the aggregated numbers)
    // it isn't important how many numbers are there before that number.
    // what matters is the sum we have calculated so far, in this case it is 1+2 = 3
    
    // One possible representation for the problem is the following:
    // i = the sum, int dp[i] = number of ways to get to that sum
    // In this example int dp[4] equals to 7
    // int dp[sum] = number_of_ways
    // we can initialize dp[0] = 1 and build up our case with transitions,
    // so what transitions can we make? if we have sum = 10 (so far) and the allowed_numbers are 1,2,and 3
    // then we can get sum 11, 12, or 13 

    //----------------------------------------------------
    // Implementation:

    // int dp[0] = 1
    // for i in 1..N:
    //     for x in nums:
    //         dp[i] += dp[i-x] 

    // N = 4
    // nums = {1,2,3}
    // => dp[0] = 1, dp[1] = 
    
    // TODO: continue

    private int[] NumofWays(int N, int[] nums, int l){
        
        int[] dp = new int[N+1];
        dp[0] = 1;

        for (int i=1; i<=N; i++){
            for( int j=0; j<l; j++){
                
                if(i-nums[j]>=0)
                    dp[i] += dp[i-nums[j]];         
            }
        }

        return dp;
    }

    public static void main( String[] args) {

        int N = 4;
        int[] nums ={1,2,3};
        
        Solution sol = new Solution();
        int[] dp = sol.NumofWays(N, nums, 3);
        sol.print(dp, N+1);

        
    }

    private void print(int[] arr, int length){
        for (int i=0;i<length;i++){
            System.out.print(arr[i]+", ");
        }
    }
}