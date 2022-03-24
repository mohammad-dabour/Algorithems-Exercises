import java.util.LinkedList;
import java.util.Queue;


public class NumberOfIslands {
    
     public static void dfs(int r, int c, char[][] grid){
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        if(r < 0 || c < 0 || r>= nr || c >= nc ||grid[r][c] == '0'){
            
            return;
        }
        
        grid[r][c] = '0';
        
        dfs(r-1, c,grid);
        dfs(r+1, c,grid);
        dfs(r, c-1,grid);
        dfs(r, c+1,grid);
        
    }
    public static int numIslands(char[][] grid) {
        
        if(grid.length == 0||grid == null) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
        
        for(int r = 0; r< nr; r++){
            
            for(int c = 0; c < nc; c++){
                
                if(grid[r][c] == '1'){
                    num++;
                    dfs(r, c, grid);
                }
            }
        }
        
        return num;
        
    }
    public static int numIslands(char[][] grid, String type) {
        
        
        
        if(grid.length == 0||grid == null) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
            
        Queue<int[]> queue = new LinkedList<>();
            
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            
        
        for(int r = 0; r< nr; r++){
            
            for(int c = 0; c < nc; c++){
                
                if(grid[r][c] == '1'){
                    
                    num++;
                    queue.add(new int[]{r,c});
                    
                    while(!queue.isEmpty()){
                       
                        
                        int[] cell = queue.poll();
                        int ri = cell[0];
                        int ci = cell[1];
                        
                         grid[ri][ci] = '0';
                        
                         for (int[] dr : dir){
                             int r1 = cell[0]+dr[0];
                             int c1 = cell[1]+dr[1];
                             
                             if(r1 >= 0 && r1 < nr && c1 >= 0 && c1 < nc && grid[r1][c1] == '1'){
                                 grid[r1][c1] = '0';
                                 queue.add(new int[]{r1,c1});
                                 
                             }
                         }
                    }
                }
            }
        }
        
        return num;
        
    }
        
       
    public static void main(String[] args) throws Exception {
        //[5,2,3,1]

        char[][] grid = {{'1','1','1','1','0'}, 
        {'1','1','0','1','0'}, 
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};


        char[][] grid2 = {{'1','1','1','1','0'}, 
        {'1','1','0','1','0'}, 
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
        //[[0,0,0],[0,1,1]]

        
            //Using DFS
            System.out.println(numIslands(grid));

            //Using BFS
             System.out.println(numIslands(grid2, "BFS"));
        
    
        

    

    }
}
