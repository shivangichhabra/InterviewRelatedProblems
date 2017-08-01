package Graph;

import java.util.Scanner;

/**
 * Created by Shivangi on 7/29/2017.
 *
 * Consider a matrix with  rows and  columns, where each cell contains either a  or a  and any cell containing a is
 * called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically,
 * or diagonally; in other words, cell  is connected to cells , , , , , , , and , provided that the location exists in
 * the matrix for that .
 * If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to
 * at least one other cell in the region but is not necessarily directly connected to all the other cells in the region.
 *
 * Task
 * Given an  matrix, find and print the number of cells in the largest region in the matrix. Note that there may be more
 * than one region in the matrix.
 *
 * Input Format
 *
 * The first line contains an integer, , denoting the number of rows in the matrix.
 * The second line contains an integer, , denoting the number of columns in the matrix.
 * Each line  of the  subsequent lines contains  space-separated integers describing the respective values filling each
 * row in the matrix.
 *
 * Output Format
 *
 * Print the number of cells in the largest region in the given matrix.
 *
 * Sample Input
 *
 * 4
 * 4
 * 1 1 0 0
 * 0 1 1 0
 * 0 0 1 0
 * 1 0 0 0
 *
 * Sample Output
 * 5
 */
public class DFS_Connected_Cell_Grid {

    public int getRegion(int[][] grid, int row, int col){
        int count = 0;
        if(grid[row][col] == 1) {
            grid[row][col] = 0;
            count++;
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if(i>=0 && j>=0 && i<grid.length && j<grid[0].length)
                        count += getRegion(grid, i, j);
                }
            }
        }
        return count;
    }

    public int getLargestRegion(int[][] grid){
        int max = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                max = Math.max(max, getRegion(grid, i, j));
            }
        }
        return max;
    }

    public static void main(String args[]){
        DFS_Connected_Cell_Grid dfs = new DFS_Connected_Cell_Grid();
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] grid = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(dfs.getLargestRegion(grid));
    }
}
