
func dfs(image [][]int, sr int, sc int, color int, initial int) {
    var nr int = len(image)
    var nc int = len(image[0])
    if sr >= nr || sc >= nc || sr < 0 || sc < 0 ||image[sr][sc]  == color ||image[sr][sc] != initial {
        
       return
    }
    image[sr][sc] = color
    dfs(image, sr + 1, sc,color, initial)
    dfs(image, sr - 1, sc,color,initial)
    dfs(image, sr, sc + 1,color,initial)
    dfs(image, sr, sc - 1,color,initial)
    
}
func floodFill(image [][]int, sr int, sc int, color int) [][]int {
    
    
    dfs(image, sr,sc,color, image[sr][sc])
    return image
}
