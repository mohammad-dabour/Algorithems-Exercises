import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Here I provided 3 ways to resolve this problem. 
// 1. recursive using DFS. 2. iterative DFS 3. BFS
// Example to call the method as mtx = floodFill(mtx, 1, 1, 2, "dfs");

public class FloodFill {

    
    
    public static void BFS(int[][] image, int r, int c, int color, int newColor){
        
        
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r,c});

        int n = image.length;
        int m = image[0].length;

        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}}; //{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

        while(!q.isEmpty()){

            System.out.println(q.size());
            int[] cell = q.poll();
            

            if(image[cell[0]][cell[1]] == color){

                image[cell[0]][cell[1]] = newColor;

                
                
                for (int[] d : dir) {

                    int rw = cell[0] + d[0];
                    int cl = cell[1] + d[1];
                    
                    if(rw >= 0 && cl >= 0 && rw < n && cl < m && image[rw][cl] == color){

                        q.add(new int[]{rw, cl});
               

                    }

                }

            }
        }
    }
    public static void dfs(int[][] image, int r, int c, int color, int newColor){
        
        if(image[r][c] == color){
            
            image[r][c] = newColor;
            
            if(r >= 1) dfs(image, r-1, c,  color, newColor);
            
            if(c >= 1) dfs(image, r, c-1,  color, newColor);
            
            if(r+1 < image.length) dfs(image, r+1, c,  color, newColor);
            
            if(c+1 < image[0].length) dfs(image, r, c+1,  color, newColor);
            
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor, String type) {
        
        
        
        if(image[sr][sc] == newColor) return image;
    
        int color = image[sr][sc];
        if(type == "dfs") dfs(image, sr, sc,  color, newColor);
        if(type == "bfs") BFS(image, sr, sc, color, newColor);
        if(type == "stk") stackFill(image, sr, sc, color, newColor);
        
    
         return image;
    }
    public static void stackFill (int[][] image, int r, int c, int color, int newColor) {
        
        Stack <int[]> stk = new Stack<>();

        stk.push(new int[]{r,c});
     

        int rows = image.length;
        int cols = image[0].length;

        while(!stk.isEmpty()){

            int[] cell = stk.pop();
            int rw = cell[0];
            int cl = cell[1];

            if(image[rw][cl] == color){

                image[rw][cl] = newColor;

                if(rw+1 < rows) stk.push(new int[]{rw+1, cl});

                if(rw-1 >= 0) stk.push(new int[]{rw-1, cl});

                if(cl+1 < cols) stk.push(new int[]{rw, cl+1});

                if(cl-1 >= 0) stk.push(new int[]{rw, cl-1});

            }
        }



    }
        
        
       
    public static void main(String[] args) throws Exception {
        //[5,2,3,1]
        int[][] mtx  =  {{1,1,1},{1,1,0},{1,0,1}}; //{{0,0,0},{0,1,1}};

        //[[0,0,0],[0,1,1]]

        mtx = floodFill(mtx, 1, 1, 2, "dfs");
        for (int[] is : mtx) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
    
        

    

    }
}
