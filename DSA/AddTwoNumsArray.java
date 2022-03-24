
import java.util.HashMap;


public class AddTwoNumsArray {

    
    private static int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
      
        
        for(int i = 0;i < nums.length; i++) {
            int x = target - nums[i];
            
            if(mp.containsKey(x)) {
                
                return new int[]{i, mp.get(x)};
                
            }else{
                mp.put(nums[i],  i);
            }
           
        }
        
        return null;
    }

 
    
    public static void main(String[] args) throws Exception {

        int[] arr = {2,5,5,11};
        int target = 10;
        int[] res = twoSum(arr, target);
       
        for (int i : res) {
            System.out.print(i+" ");
        }
        System.out.println();
        
    }
}
