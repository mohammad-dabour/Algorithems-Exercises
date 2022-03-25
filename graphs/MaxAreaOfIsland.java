// https://leetcode.com/problems/max-area-of-island/

public class MaxAreaOfIsland {

    

    private static int dfs(int[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        
        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c]==0)
            return 0;

        grid[r][c] = 0;
        
        return 1+dfs(grid, r+1, c) + dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
    }
    private static int maxAreaOfIsland(int[][] grid) {
        
        int nr = grid.length;
        int nc = grid[0].length;
        int maxArea = 0;
        
        for(int i = 0; i< nr; i++){
            for(int j = 0; j< nc; j++){
                if(grid[i][j] == 1)
                maxArea = Math.max(dfs(grid, i, j), maxArea);
            }
        }
     
        return maxArea;
    }
    
    public static void main(String[] args) throws Exception {

        
         
            int[][ ] grid  = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}};


            
      
        
        System.out.println(maxAreaOfIsland(grid));
        
    }
}
