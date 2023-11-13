package helloAlgo;

public class MaxIsland {
    static int count = 0;


    public static void main(String[] args) {
        int[][] array = {   {0,0,1,0,0,0,0,1,0,0,0,0,0},
                            {0,0,0,0,0,1,0,1,0,1,0,0,0},
                            {0,0,1,1,0,0,0,0,1,1,0,0,0},
                            {0,0,1,0,0,0,0,1,0,1,0,0,0},
                            {0,0,0,0,0,0,0,1,0,0,0,0,0},
                            {0,0,1,1,1,0,0,0,1,1,0,0,0},
                            {0,0,1,1,1,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,1,1,1,0,1,0,0,0},
                            {0,0,1,1,0,0,1,0,0,1,0,0,0},
                            {0,0,0,1,0,0,0,1,1,1,0,0,0},


        };

        System.out.printf( maxAreaOfIsland(array)+"  points  " );




    }

    public static int maxAreaOfIsland(int[][] grid) {

        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                 if(grid[i][j]!=0){
                     count  = 0;
                     dfs(i, j, grid);
                     res =  Math.max(res,count);

                 }
            }
        }
        return res;


    }
    public static void  dfs(int i, int j, int[][] grid){
        if(i>= grid.length|| j>=grid[0].length ||  i<0||j<0||grid[i][j]==0) return;
        count++;
        grid[i][j] = 0;
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);


    }


}
