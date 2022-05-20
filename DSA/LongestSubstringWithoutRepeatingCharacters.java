class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        int n = s.length();
        int res = 0;
        int right = 0;
        int left = 0;
        
     
        Map<Character, Integer> mp = new HashMap<>();
        
        
        
        while(right < n){
            
            char r = s.charAt(right);
            
            if(mp.containsKey(r)){
                left = Math.max(left, mp.get(r));
            }
            
            res = Math.max(res, right - left + 1);
            right++;
            mp.put(r, right);

            
        }
        return res;
    }
    
   
}
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        int n = s.length();
        int res = 0;
        int left = 0;
        int right = 0;
     
        int[] chars = new int[128];
        
        while(right < n){
            
            char r = s.charAt(right);
            chars[r]++;
            
            while(chars[r] > 1){
                
                char temp = s.charAt(left);
                chars[temp]--;
                left++;
            }
            
            res = Math.max(res, right - left + 1);
            
            right++;
            
        }
        return res;
    }
    
    public boolean check(String s, int start, int end) {
        
        int[] chars = new int[128];
        
        for(int i = start; i<=end; i++){
            char c = s.charAt(i);
            chars[c]++;
            if(chars[c] > 1) return false;
           
        }
        return true;
    }
}*/
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        int n = s.length();
        int res = 0;
     
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                
                if(check(s, i, j)) res = Math.max(res, j-i+1);
                 else break;
            }
        }
        return res;
    }
    
    public boolean check(String s, int start, int end) {
        
        int[] chars = new int[128];
        
        for(int i = start; i<=end; i++){
            char c = s.charAt(i);
            chars[c]++;
            if(chars[c] > 1) return false;
           
        }
        return true;
    }
}*/
