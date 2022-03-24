public class SortAnArrayUsingHeap {

    public static void hipify(int[] nums, int n, int i){
        
        int large = i;
        int leftNode =  2 * i + 1;
        int rightNode = 2 * i + 2;
        
        
        if(leftNode < n && nums[leftNode]  > nums[large]) 
            large = leftNode;
        
        if(rightNode < n && nums[rightNode]  > nums[large]) 
            large = rightNode;
        
        if(large != i){
            int temp = nums[i];
            nums[i] = nums[large];
            nums[large] = temp;
            
            
            hipify(nums, n, large);
            
        }
        
    }
    public static int[] sortArray(int[] nums) {
        
        int n = nums.length;
        
        // This solution will use Heap-Sort
        
        // Step 1: Let's make sure the array is heap in another word lets build the heap.
        
        for(int i = n/2 - 1; i>=0; i--) {  // n/2-1  we're skipping the leaf nodes.
            
            hipify(nums, n, i);
        }
        
        // Step 2: Now we assume we have a MAX-heap
        // So let's go and delete the root by adding it to the end of the array and having last element into it's place, then hipify the array.
        
        for(int i = n-1; i>0; i--){
            int temp = nums[0]; //root
            nums[0] = nums[i]; // replace 1st with last.
            nums[i] = temp; // write root to last.
            
            // Now we need to hipify again, to make sure we have a valid MAX-HEAP.
            hipify(nums, i, 0); // Note the size reduced by 1 each time, because we won't look at deleted elements while we do the hipify.
        }
        
        
        return nums;
        
    }
    public static void main(String[] args) throws Exception {
        //[5,2,3,1]
        int[] nums = {5,2,3,1};

        nums = sortArray(nums);

        for (int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
