import java.util.HashMap;

public class MinCostClimbingStairs {
    
        
    private static HashMap<Integer, Integer> mem = new HashMap<>();
    



    public static int minCostClimbingStairs(int[] cost, String type) {
        int n = cost.length; 
        int[] minCost = new int[cost.length+1];
        
        minCost[0] = 0;
        minCost[1] = 0;
        
        for(int i = 2; i < cost.length+1; i++){
            
            minCost[i] = Math.min(minCost[i-1]+cost[i-1], minCost[i-2]+cost[i-2]);
        }
        
        return minCost[n];
        
    }
        


    public static int minCost(int[] cost, int i, String type){


        if( i <= 1) return 0;

        if(mem.containsKey(i)) return mem.get(i);

        int oneStep = cost[i - 1] + minCost(cost, i - 1, "hash");
        int twoSteps = cost[i - 2] + minCost(cost, i - 2, "hash");
        mem.put(i, Math.min(oneStep, twoSteps));
        return mem.get(i);    
    }

    public static int minCost(int[] cost, int i, int[] mem){


        if( i <= 1) return 0;

        if(mem[i] > 0) return mem[i];

        int oneStep = cost[i - 1] + minCost(cost, i - 1, mem);
        int twoSteps = cost[i - 2] + minCost(cost, i - 2, mem);
        mem[i] = Math.min(oneStep, twoSteps);
        return mem[i];    
    }

    // Using Top-Down approach .. Memoization
    public static int minCostClimbingStairs(int[] cost) {
        return minCost(cost, cost.length, "hashmap");
    }
    public static int minCostClimbingStairs(String type,int[] cost) {
        if(type != "const")
        return minCost(cost, cost.length, new int[cost.length+1]);

        int current = 0;
        int prev = 0;

        for(int i =2; i < cost.length+1; i++){
            int temp = current;
            current = Math.min(current + cost[i -1],  + cost[i - 2]);
            prev = temp;
        }

        return current;
    }
    public static void main(String[] args) throws Exception {



       // int[] memo = new int[4];

        int[] cst = {10,15,20};
        System.out.println(minCostClimbingStairs(cst, "Bottom-Up"));
        System.out.println(minCostClimbingStairs("array", cst));
        System.out.println(minCostClimbingStairs("const", cst));
        System.out.println(minCostClimbingStairs(cst));
        
        

        
    
        

    

    }
}
