import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            int min = matrix[i][0];
            int col = 0;

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    col = j;
                }
            }

            boolean lucky = true;

            for (int k = 0; k < rows; k++) {
                if (matrix[k][col] > min) {
                    lucky = false;
                    break;
                }
            }

            if (lucky) {
                result.add(min);
            }
        }

        return result;
    }
}