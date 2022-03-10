import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        
        if( grid[0][0] !=0 ) return -1;
        
        int n = grid.length; //it is nxn enoguth to have n for both row and column
        
        Queue<int[]> queue = new  LinkedList<>();
        
        // 0,0 are the cell coordinate, and 1 is the step count
        queue.add(new int[]{0,0,1});
        grid[0][0] = 1; // mark it as visited so it does not get checked.
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
        
        
        while(!queue.isEmpty()){
            
            int[] cell = queue.poll();
            
            if (cell[0] == n-1 && cell[1] == n-1) return cell[2];
            
            for(int[] dr : dir){
                
                int row = cell[0] + dr[0];
                int col = cell[1] + dr[1];
                
                if(row >= 0 && col >= 0 && row < n && col < n && grid[row][col] == 0){
                    
                    queue.add(new int[]{row, col, cell[2] + 1});
                    grid[row][col] = 1;
                    
                }
            }
        }
        
        return -1;
        
    }
        
       
    public static void main(String[] args) throws Exception {
      
        int[][] mtx  = {{0,1},{1,0}};

    
        System.out.println(shortestPathBinaryMatrix(mtx));

    }
}
