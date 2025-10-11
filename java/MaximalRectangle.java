   import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m]; // Histogram heights
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // Build histogram for this row
                if(matrix[i][j] == '1') {
                    heights[j] += 1; // add 1 to the height
                } else {
                    heights[j] = 0; // reset height if '0'
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        // Nearest Smaller to Left
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // Clear stack
        st.clear();

        // Nearest Smaller to Right
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate max area
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}


