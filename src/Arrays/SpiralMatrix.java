/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return result;

        /*
        1 1 1 1 1
        1 2 2 2 1
        1 2 3 2 1
        1 2 2 2 1
        1 1 1 1 1
        */

        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length-1;

        while(r1 <= r2 && c1 <= c2){
            //add column from c1 to c2 for row r1
            for(int i=c1; i<=c2; i++)
                result.add(matrix[r1][i]);

            //add row from r1 to r2-1 for c2
            for(int i=r1+1; i<=r2; i++)
                result.add(matrix[i][c2]);

            if(r1 < r2 && c1 < c2){
                //add column from c2 to c1-1 for r2
                for(int i=c2-1; i>c1; i--)
                    result.add(matrix[r2][i]);

                //add row from r2 to r1-1 for c1
                for(int i=r2; i>r1; i--)
                    result.add(matrix[i][c1]);
            }

            r1++; r2 --;
            c1++; c2--;
        }

        return result;
    }
}
