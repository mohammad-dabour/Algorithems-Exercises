import java.util.LinkedList;
import java.util.Queue;

public class LargestMagicSquare {

    public static int largestMagicSquare(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] rowSum = new int[n+1][m+1];
        int[][] colSum = new int[n+1][m+1];
        int[][] diagSum = new int[n+1][m+1];
        int[][] antiDiagSum = new int[n+1][m+1];
        
        for(int i = 0; i< n; i++){
            
            for(int j = 0; j< m; j++){
                
                rowSum[i+1][j+1] = rowSum[i+1][j] + grid[i][j];
                colSum[i+1][j+1] = colSum[i][j+1] + grid[i][j];
                
                diagSum[i+1][j+1] = diagSum[i][j] + grid[i][j];
                
                antiDiagSum[n-i-1][m-j] = antiDiagSum[n-i][m-j-1] + grid[n-i-1][m-j-1];
                
                
            }
        }
        
        int max = 1; //We know min can be 1. by default.
        
        for(int size = 2; size <= Math.min(m,n); size++){
            
            for(int i = size - 1; i < n; i++){
                
                for(int j = size - 1; j < m; j++){
                    
                    boolean isrow = true;
                    
                    int diff = rowSum[i + 1][j + 1] - rowSum[i + 1][j + 1 -size];
                    
                    for(int k = i - size + 1; k < i; k ++){
                        
                        if(rowSum[k+1][j+1] - rowSum[k+1][j + 1 - size] != diff){
                            isrow = false;
                            break;
                        }    
                    }
                    
                    if(!isrow) continue;
                    
                    boolean isCol = true;
                    
                    int coldiff = colSum[i+1][j+1] - colSum[i + 1 - size][j+1];
                    
                    if(coldiff != diff) continue;
                    
                    for(int k = j - size + 1; k<j; k++){
                        if(colSum[i+1][k+1] - colSum[i+1-size][k+1] != coldiff){
                            isCol = false;
                            break;
                        }
                    }
                    
                    if(!isCol) continue;
                   
                    
                    int digDiff = diagSum[i+1][j+1] - diagSum[i+1 - size][j+1 -size];
                    int antiDiff = antiDiagSum[i+1-size][j+1] - antiDiagSum[i+1][j+1-size];
                    
                    if(digDiff == antiDiff && digDiff == coldiff) max = Math.max(size, max);
                    
                }
            }
        }
        
        return max;
    }
        
        
    
        
       
    public static void main(String[] args) throws Exception {
        //[5,2,3,1]
        int[][] mtx  = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};

    
        System.out.println(largestMagicSquare(mtx));

    }
}
