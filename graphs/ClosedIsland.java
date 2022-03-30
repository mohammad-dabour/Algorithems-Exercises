// https://leetcode.com/problems/number-of-closed-islands/

public class ClosedIsland {

    
    private static  boolean dfs(int[][] grid, int r, int c){
        
       
        // The whole concept of this solution ..
        // As long as we do not get false we're having the closed island.
        // The closed Island depends on one thing being srounded by ones. 
        // We return true when we get one because one is the determentat of the island being closed.
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        if(r < 0 || c < 0 || r >= nr || c >= nc) return false;
        
        
        if(grid[r][c] == 1) return true; 
        
        grid[r][c] = 1;
        
        
        boolean rDown = dfs(grid, r - 1, c);
        boolean rUp = dfs(grid, r + 1, c);
        boolean cLeft = dfs(grid, r, c - 1);
        boolean cRight = dfs(grid, r, c + 1);
       
        
        return rDown && rUp && cLeft && cRight;
        
    }
    

    private static int closedIsland(int[][] grid) {
        

        
        int nr = grid.length;
        int nc = grid[0].length;
        int numbClosedIsland = 0;
        
        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++){
                
                if(grid[r][c] == 0 && dfs(grid,r,c)) numbClosedIsland++;
            }
        }
        
        return numbClosedIsland;
        
    }
    
    public static void main(String[] args) throws Exception {

        
         
            int[][] grid  = {{0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}};


            
            
      
        
        System.out.println(closedIsland(grid));
        
    }
}
