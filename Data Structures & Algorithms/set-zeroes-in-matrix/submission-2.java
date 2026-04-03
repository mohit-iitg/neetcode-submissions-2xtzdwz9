class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Need to preserve the state of first row and columns
        // otherwise they can become zero in the process
        // We would lose the data on each row and column being zero
        for(int i=0;i<m;i++) {
            if(matrix[i][0] == 0) firstColZero = true;
        }

        for(int j=0;j<n;j++) {
            if(matrix[0][j] == 0) firstRowZero = true;
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // rows
        for(int i=1;i<m;i++) {
            // checking left column
            if(matrix[i][0] == 0) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // cols
        for(int j=1;j<n;j++) {
            // checking first row
            if(matrix[0][j] == 0) {
                for(int i=0;i<m;i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstRowZero) {
            for(int j=0;j<n;j++) {
                matrix[0][j] = 0;
            }
        }

        if(firstColZero) {
            for(int i=0;i<m;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
