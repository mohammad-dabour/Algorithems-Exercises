public class ClimbStairs {
    


    // Tabulation Cost O(n) both complexity and space 

    public static int climbStairs(int n) {
            
        int[] dp = new int[n+1];
         
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i< dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
     }
  
    // Brute Force approache O(2^n)
    /*
    public int climbStairs(int n) {
        
        return climb_stairs(0, n);
    }
    
    public int climb_stairs(int i, int n){
        
        if(i == n) return 1;
        
        if(i > n) return 0;
        
        return climb_stairs(i+1, n) + climb_stairs(i+2, n);
        
        
        
    }*/
    
   

        // Fibonanici Approach costs O(n) but with O(1) space.
        public static int climbStairs(String type, int n) {
            
            if(n == 1) return 1;

            int first = 1;
            int  second = 2;

            for(int i = 3; i <= n; i++ ){
                int third = first + second;

                first = second;
                second = third;
            }

            return second;
         }
  
  
         // MemoizationCost O(n) both complexity and space 
        public static int climbStairs(int n, String type) {
            
           int[] memo = new int[n+1];
            
            return climb_stairs(0, n, memo);
        }
        
  
  
        public static int climb_stairs(int i, int n, int[] memo){
            
            if(i == n) return 1;
            
            if(i > n) return 0;
            
            if(memo[i] > 0) return memo[i];
            
            memo[i] = climb_stairs(i+1, n, memo) + climb_stairs(i+2, n, memo);
            
            return memo[i];
            
            
            
        }
    

      
        
       
    public static void main(String[] args) throws Exception {



       // int[] memo = new int[4];

        System.out.println(climbStairs(4, "memo"));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs("fib",4));
        

        
    
        

    

    }
}
