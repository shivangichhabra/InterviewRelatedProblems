package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class Pair{
        int num;
        int frequency;

        public Pair(int n, int f){
            num = n;
            frequency = f;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            int count = 0;
            if(map.containsKey(nums[i])){
                count = map.get(nums[i]);
            }
            map.put(nums[i], count+1);
        }


        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.frequency - b.frequency;
            }
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size() > k)
                queue.poll();
        }

        while(queue.size() > 0){
            result.add(queue.poll().num);
        }


        return result;
    }
}
