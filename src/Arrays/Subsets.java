package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


 */
public class Subsets {

    //Iterative
    public List<List<Integer>> getSubsetsI(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>()); //Empty Set

        //Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> list : result){
                List<Integer> l = new ArrayList<>(list);
                l.add(nums[i]);
                temp.add(l);
            }
            result.addAll(temp);
        }

        return result;
    }

    //using DFS
    public List<List<Integer>> getsubsetsR(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, nums, 0, new ArrayList<Integer>());
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, int index, List<Integer> list){
        result.add(new ArrayList<Integer>(list));
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            dfs(result, nums, i+1, list);
            list.remove(list.size()-1);
        }
    }


}
