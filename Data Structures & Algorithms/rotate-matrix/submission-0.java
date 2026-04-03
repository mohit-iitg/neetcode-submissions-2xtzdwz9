class Solution {
    public void rotate(int[][] matrix) {
        int r1 = 0, r2 = matrix.length-1, c1 = 0, c2 = matrix[0].length-1;

        while(r1 <= r2 && c1 <= c2) {
            int size = r2-r1;
            for(int i=0; i<size; i++) {
                // swap the first element of the row 
                // completely in a cycle
                int pos1 = matrix[r1][c1+i];
                int pos2 = matrix[r1+i][c2];
                int pos3 = matrix[r2][c2-i];
                int pos4 = matrix[r2-i][c1];

                matrix[r1+i][c2] = pos1;
                matrix[r2][c2-i] = pos2;
                matrix[r2-i][c1] = pos3;
                matrix[r1][c1+i] = pos4;
            }
            r1++; r2--; c1++; c2--;
        }

    }
}
