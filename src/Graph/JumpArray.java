package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Can you reach zero in the array game?
You're given an array of integers, such as arr = [3, 4, 2, 3, 0, 3, 1, 2, 1], and a startIndex.
When you're at an index i, you can move left or right by arr[i]. Your task is to figure out if you can reach 0.
*/

public class JumpArray {
    public static void main(String args[]){
        int[] array = {9,4,2,3,0,3,1,2,1};
        int startIndex = 3;
        System.out.println(findZero(array, startIndex));
    }

    public static boolean findZero(int[] array, int startIndex){
        if(array.length == 0 || array == null || startIndex < 0 || startIndex > array.length)
            return false;

        boolean[] visited = new boolean[array.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);

        while(!queue.isEmpty()){
            int currentIdx = queue.poll();
            visited[currentIdx] = true;

            if(array[currentIdx] == 0)
                return true;

            int left = currentIdx - array[currentIdx];
            int right = currentIdx + array[currentIdx];

            if(left > 0 && !visited[left])
                queue.offer(left);

            if(right<array.length && !visited[right])
                queue.offer(right);
        }
        return false;
    }
}
