package puzzles;

public class WaterJugProblem {

    public int gctarget(int a, int b){
        if( b == 0)
            return a;
        return gctarget(b, a%b);
    }

    public boolean canMeasureWater(int bucket1, int bucket2, int target){
        if(bucket1 == target || bucket2 == target || bucket1+bucket2 == target)
            return true;

        if(bucket1 + bucket2 < target)
            return false;
        
        return target % gctarget(bucket1, bucket2) == 0;
    }

    public int countSteps(int frombucket, int tobucket, int target) {
        if(frombucket + tobucket == target)
            return 1;
        int from = frombucket;
        int to = 0;
        int steps = 1;

        while (from != target && to != target) {
            int temp = Math.min(from, tobucket - to);

            from -= temp;
            to += temp;
            steps++;

            if(from == target || to == target)
                break;

            if(from == 0){
                from = frombucket;
                steps++;
            }

            if(to == tobucket) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }

    public int getMinSteps(int bucket1, int bucket2, int target){
        if(target < 0)
            return -1;
        if(target == 0 && bucket1 == 0 && bucket2 == 0)
            return 0;

        if(bucket1 > bucket2){
            int temp = bucket1;
            bucket1 = bucket2;
            bucket2 = temp;
        }

        if(canMeasureWater(bucket1, bucket2, target)) {
            return Math.min(countSteps(bucket1, bucket2, target), countSteps(bucket2, bucket1, target));
        }

        return -1;
    }

    public static void main(String arg[]){
        WaterJugProblem wj = new WaterJugProblem();
        System.out.println(wj.getMinSteps(3,5,4));
        System.out.println(wj.getMinSteps(5,3,4));
        System.out.println(wj.getMinSteps(0,0,0));
        System.out.println(wj.getMinSteps(5,3,0));
        System.out.println(wj.getMinSteps(5,3,10));
        // System.out.println(wj.getMinSteps(5,3,2));
        System.out.println(wj.getMinSteps(5,3,-1));
        System.out.println(wj.getMinSteps(5,3,8));
    }
}
