package String;

/**
 * Created by Shivangi on 8/13/2017.
 *
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
 * which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are
 * R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 *
 * Example 1:
 * Input: "UD"
 * Output: true
 *
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class JudgeRouteCircle {

    public boolean judge(String moves){
        int x =0, y=0;
        for(char c : moves.toCharArray()){
            x += (c == 'L' ? 1 : 0) - (c == 'R' ? 1 : 0);
            y += (c == 'U' ? 1 : 0) - (c == 'D' ? 1 : 0);
        }
        return x==0 && y==0;
    }

    public static void main(String args[]){
        JudgeRouteCircle circle = new JudgeRouteCircle();
        String inputMoves = "LRDD";
        System.out.println(circle.judge(inputMoves));
    }
}

