package Arrays;

public class ZeroMatrix {

    public static void main(String args[]){
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("BEFORE");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }

        ZeroMatrix z = new ZeroMatrix();
        z.setZeroes(matrix);

        System.out.println("AFTER");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        //get first row
        boolean rowHasZero = false;
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowHasZero = true;
                break;
            }
        }

        //get first colum
        boolean columnHasZero = false;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                columnHasZero = true;
                break;
            }
        }

        //nullify other rows and columns
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //nullify rows based on first column
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0] == 0)
                nullifyRow(matrix,i);

        }

        //nullify columns based on first row
        for(int i=1; i<matrix[0].length; i++){
            if(matrix[0][i] == 0)
                nullifyColumn(matrix,i);

        }

        if(rowHasZero)
            nullifyRow(matrix,0);

        if(columnHasZero)
            nullifyColumn(matrix,0);
   }

    public void nullifyRow(int[][] matrix, int row){
        for(int i=0; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }

    public void nullifyColumn(int[][] matrix, int column){
        for(int i=0; i<matrix.length; i++){
            matrix[i][column] = 0;
        }
    }
}
