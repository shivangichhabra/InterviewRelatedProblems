package DP;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        //base case
        if(dungeon.length == 0 || dungeon[0].length == 0 || dungeon == null)
            return -1;

        int m = dungeon.length;
        int n = dungeon[0].length;
        //create dp array
        int[][] hp = new int[m][n];

        //health at princesses location
        hp[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);

        // init last row
        for(int i=m-2; i>=0; i--){
            hp[i][n-1] = Math.max(hp[i+1][n-1] - dungeon[i][n-1], 1);
        }

        // init last column
        for(int j=n-2; j>=0; j--){
            hp[m-1][j] = Math.max(hp[m-1][j+1] - dungeon[m-1][j], 1);
        }

        // update the table
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                int down = Math.max(hp[i+1][j] - dungeon[i][j], 1);
                int right = Math.max(hp[i][j+1] - dungeon[i][j], 1);
                hp[i][j] = Math.min(right, down);
            }
        }

        return hp[0][0];
    }
}
