package helloAlgo;

import java.util.*;

public class BackTrack {

    public static void main(String[] args) {
        int[] x = {1, 1, 3, 4, 5, 6};
        List<List<Integer>> res = new ArrayList<List<Integer>>();



        backTrack(new ArrayList<>(),x,new boolean[x.length],res);
        for (int i = 0; i < res.size(); i++) {
            System.out.printf(res.get(i) + "\n");
        }
        System.out.printf(res.size() + "\n");
    }
    public static void backTrack(List<Integer> list ,int[] choices, boolean[] selected,List<List<Integer>> res) {
        if(list.size()==choices.length){
            res.add(new ArrayList<>(list));
            return ;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<choices.length;i++){
            int choice = choices[i];
            if(!selected[i] && ! set.contains((choice))){
                set.add(choice);
                selected[i] = true;
                list.add(choice);
                backTrack(list,choices,selected,res);
                selected[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
