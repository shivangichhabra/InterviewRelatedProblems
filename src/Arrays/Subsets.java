package Arrays;

import java.util.ArrayList;
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
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, nums, 0, new ArrayList<Integer>());
        return result;
    }

    public void backTrack(List<List<Integer>> result, int[] nums, int index, List<Integer> list){
        result.add(new ArrayList<Integer>(list));
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            backTrack(result, nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
