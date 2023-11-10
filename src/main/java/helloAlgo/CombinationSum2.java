package helloAlgo;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2,1,1,1,1,1, 7, 6, 1, 5};
        int target = 8;
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }
    public    List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res =   new ArrayList<List<Integer>>();
        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res ;

    }

    public void dfs(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(list));
            return ;
        }
        for(int i=start; i<candidates.length;i++){
            if(target<candidates[i]){
                break;
            }
            if( i>start&& candidates[i]==candidates[i-1]) {
                continue;
            }
            list.add((candidates[i]));
            dfs(candidates, target- candidates[i],i+1, list, result);
            list.remove(list.size()-1);
            }
        }






}




