import java.util.Arrays;

public class HouseRobber {
    
    
    // Using Top-Down approach .. Memoization

    private static int[] mem;


    private static int rob(int[] nums){

        mem = new int[nums.length];
        Arrays.fill(mem, -1);

        return robFrom(0, nums);
    }

    private static int robFrom(int i, int[] nums){


        if(i >= nums.length) return 0;

        if(mem[i] > -1) return mem[i];

        int rob = Math.max(robFrom(i + 1, nums), robFrom(i + 2, nums) + nums[i]);
        mem[i] = rob;
        return rob;
        
    }

    private static int rob(String tabs,int[] nums){

        int n = nums.length;
        
        if(n == 0) return 0;

        int[] tab = new int[n+1];

        tab[n] = 0;
        tab[n-1] = nums[n-1];

        for(int i = n - 2; i >= 0; i--){

            tab[i] = Math.max(tab[i+1], tab[i+2]+nums[i]);
        }

        return tab[0];
   
    }

    private static int rob(int constant,int[] nums){

        int n = nums.length;
        
        if(n == 0) return 0;

        

        int old = 0;
        int recent = nums[n-1];

        for(int i = n - 2; i >= 0; i--){

            int current = Math.max(recent, old+nums[i]);

            old = recent;
            recent = current;


        }

        return recent;
   
    }

    public static void main(String[] args) throws Exception {
        
        int[] cst = {2,7,9,3,1};
        System.out.println(rob(cst));

        System.out.println(rob("tab",cst));
        System.out.println(rob(1,cst));



    }
}
