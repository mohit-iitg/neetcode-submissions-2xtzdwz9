class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, visited, i, j, m, n);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j] == true) return;

        visited[i][j] = true;
        dfs(grid, visited, i-1, j, m, n);
        dfs(grid, visited, i+1, j, m, n);
        dfs(grid, visited, i, j-1, m, n);
        dfs(grid, visited, i, j+1, m, n);
    }
}
