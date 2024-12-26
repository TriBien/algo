// ref: https://leetcode.com/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public void setZeroes(int[][] matrix) {

        boolean hasZeroFirstRow = false;
        boolean hasZeroFirstColumn = false;

        // Step 1: check any zero in the first row & first column and update the above flags
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                hasZeroFirstColumn = true;
                break;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                hasZeroFirstRow = true;
                break;
            }
        }

        // Step 2: scan from the second row & second column to search any zero and mark that position in 
        // the first row & the first column -> use column[0] & row[0] as the memory card
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: scan memory card and set zero the whole marked column & rows
        for (int i = 1; i < matrix.length; i++) { 
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        
        }

        // Step 4: check hasZeroFirstRow & hasZeroFirstColumn to set zeros for column[0] & row[0] if needed
        if (hasZeroFirstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (hasZeroFirstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void print(int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            builder.append("[");
            for (int j = 0; j < matrix[0].length; j++) {
                builder.append(matrix[i][j]);
                builder.append(" ");
            }
            builder.append("]");
            builder.append("\n");
        }
        System.out.println(builder);
    }
}