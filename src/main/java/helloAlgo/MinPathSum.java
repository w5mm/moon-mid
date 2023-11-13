package helloAlgo;

public class MinPathSum {
    int minPathSum(int[][] grid,int[][] mem, int i ,int j){
        if(i == 0 && j == 0){
            return grid[0][0];

        }
        if(i<0||j<0){
            return Integer.MAX_VALUE;
        }
        if(mem[i][j] != -1){
            return mem[i][j];
        }
        int left =  minPathSum(grid,mem, i, j);
        int up = minPathSum(grid,mem,i,j);
        mem[i][j]  =Math.min(left,up)+grid[i][j];
        return mem[i][j];
    }
}
