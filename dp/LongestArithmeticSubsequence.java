package dp;

public class LongestArithmeticSubsequence {
    

    /**
     * 
     * These are 3 ways to solve this problem 1st solution is the optimal soltuion. 
     * However this solution will be perfect with the constraints provided byt leetcode 1027. Longest Arithmetic Subsequence
     * which says 0 <= nums[i] <= 500 &&  2 <= nums.length <= 1000
     * Else you'll have 2^m possible value which makes this solution not approprite. means infininte. so you can not define the columns.
     * In such case we resort to solution number 2.
     */


    public int longestArithSeqLength(int[] nums) {
        
    
        int n = nums.length;
        int[][] seq = new int[n][1001];
        
        int max = 2;
        
        for(int i =0; i< n; i++){
            for(int j=i+1; j<n; j++){
                
                int diff = nums[j] - nums[i] + 500;
                
                seq[j][diff] = seq[i][diff] > 0 ? seq[i][diff]+1 : 2;
                
                max = Math.max(max, seq[j][diff]);
                
            }
        }
        
        return max;
        
    }

    // 2d solution using HashMap 
        
    /*public int longestArithSeqLength(int[] nums) {
        
    

        HashMap<Integer, Integer> [] dp = new HashMap[nums.length];
        int maxV = 2;
       
    
        
        for(int i = 0; i< nums.length; i++){
            int current = nums[i];
            dp[i] = new HashMap();
            for(int  j = 0; j< i; j++){
                
                int diff =  current - nums[j];
                int found = dp[j].getOrDefault(diff, 0) + 1;
                dp[i].put(diff, found);
                maxV = Math.max(maxV, dp[i].get(diff));
            }
        }
        
        return maxV+1;
    }*/

    //3rd solution is Naive and with complexcity O(n^3)
    /*public int longestArithSeqLength(int[] nums) {
        
    
        int max = 2;
        int currentseq = 0;
        int next, diff;
        for(int i = 0; i< nums.length-1; i++){
            for(int  j = i+1; j<nums.length;j++){
                
                diff = nums[j] - nums[i];
                currentseq = 2;
                next = diff + nums[j];
                for(int k = j+1; k < nums.length; k++){
                    if(nums[k] == next){
                        
                        currentseq+=1;
                        max = Math.max(currentseq, max);
                        next = diff + nums[k];
                        
                    }
                }
                
            }
        }
        return max;
    }*/

    
  
      
}
