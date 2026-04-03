class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islandCount = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    islandCount++;
                    bfs(grid, i, j, m, n);
                }
            }
        }

        return islandCount;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return (0 <= i && i < m && 0 <= j && j < n);
    }

    private void bfs(char[][] grid, int i, int j, int m, int n) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];

            if(isValid(x-1, y, m, n) && grid[x-1][y] == '1') {
                queue.add(new int[]{x-1, y});
                grid[x-1][y] = '0';
            }
            if(isValid(x+1, y, m, n) && grid[x+1][y] == '1') {
                queue.add(new int[]{x+1, y});
                grid[x+1][y] = '0';
            }
            if(isValid(x, y-1, m, n) && grid[x][y-1] == '1') {
                queue.add(new int[]{x, y-1});
                grid[x][y-1] = '0';
            }
            if(isValid(x, y+1, m, n) && grid[x][y+1] == '1') {
                queue.add(new int[]{x, y+1});
                grid[x][y+1] = '0';
            }
        }
    }
}
