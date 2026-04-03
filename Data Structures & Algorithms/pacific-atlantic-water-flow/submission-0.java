class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacificFlow = new boolean[m][n];
        boolean[][] atlanticFLow = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<int[]>();
        List<List<Integer>> result = new ArrayList<>();

        // add pacific edges
        for(int j=0;j<n;j++) {
            queue.add(new int[]{0, j});
            pacificFlow[0][j] = true;
        }

        for(int i=1;i<m;i++) {
            queue.add(new int[]{i, 0});
            pacificFlow[i][0] = true;
        }

        bfs(queue, heights, pacificFlow);

        // add atlantic edges
        for(int j=0;j<n;j++) {
            queue.add(new int[]{m-1, j});
            atlanticFLow[m-1][j] = true;
        }

        for(int i=0;i<m-1;i++) {
            queue.add(new int[]{i, n-1});
            atlanticFLow[i][n-1] = true;
        }

        bfs(queue, heights, atlanticFLow);

        // compare the two flows, get the common ones
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(pacificFlow[i][j] && atlanticFLow[i][j]) {
                    List<Integer> point = new ArrayList<Integer>();
                    point.add(i); point.add(j);
                    result.add(point);
                }
            }
        }

        return result;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return (x>=0 && x<m && y>=0 && y<n);
    }

    private void bfs(Queue<int[]> queue, int[][] heights, boolean[][] reachable) {
        int m = heights.length, n = heights[0].length;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];

            // up
            if(isValid(x-1, y, m, n) && heights[x-1][y] >= heights[x][y] && !reachable[x-1][y]) {
                queue.add(new int[]{x-1, y});
                reachable[x-1][y] = true;
            }

            // down
            if(isValid(x+1, y, m, n) && heights[x+1][y] >= heights[x][y] && !reachable[x+1][y]) {
                queue.add(new int[]{x+1, y});
                reachable[x+1][y] = true;
            }

            // left
            if(isValid(x, y-1, m, n) && heights[x][y-1] >= heights[x][y] && !reachable[x][y-1]) {
                queue.add(new int[]{x, y-1});
                reachable[x][y-1] = true;
            }

            // right
            if(isValid(x, y+1, m, n) && heights[x][y+1] >= heights[x][y] && !reachable[x][y+1]) {
                queue.add(new int[]{x, y+1});
                reachable[x][y+1] = true;
            }
        }
    }
}
