class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n];
        int components = 0;
        Arrays.fill(visited, -1);

        for(int i=0;i<n;i++) {
            if(visited[i] == -1) {
                components++;
                dfs(n, graph, visited, i);
            }
        }

        return components;
    }

    private void dfs(int n, List<List<Integer>> graph, int[] visited, int node) {
        visited[node] = 1;

        for(int neighbour:graph.get(node)) {
            if(visited[neighbour] == -1) {
                dfs(n, graph, visited, neighbour);
            }
        }
    }
}
