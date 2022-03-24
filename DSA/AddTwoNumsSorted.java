


//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

public class AddTwoNumsSorted {

    
    private static int[] twoSum(int[] numbers, int target)  {
        
        int l = 0;
        int h = numbers.length - 1;
        
        while(l < h){
            
            int sum = numbers[l] + numbers[h];
            
            if(sum == target) return new int[]{l+1,h+1};
            
            if(sum > target) h--;
            
            if(sum < target) l++;
            
        }
        return null;
    }

 
    
    public static void main(String[] args) throws Exception {

        int[] arr = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(arr, target);
       
        for (int i : res) {
            System.out.print(i+" ");
        }
        System.out.println();
        
    }
}
