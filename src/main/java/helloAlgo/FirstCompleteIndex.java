package helloAlgo;

import java.util.HashMap;
import java.util.Map;

public class FirstCompleteIndex {

    public static void main(String[] args) {
        FirstCompleteIndex index = new FirstCompleteIndex();
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat ={{3,2,5},{1,4,6},{8,7,9}};
        System.out.printf("da"+index.firstCompleteIndex(arr,mat));
    }



    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = mat[0].length, height = mat.length;
        Map<Integer,int[]> map = new HashMap<Integer,int[]>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <len;j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] column = new int[len], row = new int[height];
        for(int i = 0; i < arr.length; i++) {
            int[] info = map.get(arr[i]);
            int x = info[0], y = info[1];
            column[y] ++ ;
            row[x] ++ ;
            if(column[y]== height || row[x] == len)return i;

        }



        return -1;

    }
}
