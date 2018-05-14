package Arrays;
/*
Problem: Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {
    /*
    Time complexity O(n^2)
    Space complexity O(2n) --> n for track of visited and n for recursion
     */
    public boolean canJump(int[] nums) {
        int[] visited = new int[nums.length];
        visited[nums.length-1] = 1;
        if(nums.length == 0 || nums == null)
            return false;
        return canJump(nums, 0, visited);
    }
    public boolean canJump(int[] nums, int startIndex, int[] visited){
        if(visited[startIndex] != 0){
            return visited[startIndex] == 1 ? true : false;
        }

        int maxjump = Math.min(startIndex+nums[startIndex], nums.length-1);
        for(int i=startIndex+1; i<=maxjump; i++){
            if(canJump(nums, i, visited)){
                visited[startIndex] = 1;
                return true;
            }
        }
        visited[startIndex] = -1;
        return false;
    }

    /*
    Greedy Solution
    time complexity O(n)
    space complexity O(1)
     */
    public boolean canJumpN(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;

        int last = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if(i+nums[i] >= last)
                last = i;
        }
        return last == 0;
    }
}
