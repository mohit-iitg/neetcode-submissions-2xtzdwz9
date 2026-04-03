class Solution {
public:
    // Check if there is a directed cycle
    bool dfs_cycle(int node, vector<int>* adj, vector<bool>& vis, vector<bool>& path) {
        if(path[node] == true) {
            return true;
        }
        path[node] = true;
        bool cycleFound = false;
        for(int i=0;i<adj[node].size();i++) {
            if(vis[adj[node][i]] == false) {
                cycleFound |= dfs_cycle(adj[node][i], adj, vis, path);
                if(cycleFound) break;
            }
        }
        vis[node] = true;
        path[node] = false;
        return cycleFound;
    }

    void dfs_topsort(int node, vector<int>* adj, vector<bool>& vis, deque<int>& q) {
        vis[node] = true;
        for(int i=0;i<adj[node].size();i++) {
            if(vis[adj[node][i]] == false) {
                dfs_topsort(adj[node][i], adj, vis, q);
            }
        }
        q.push_front(node);
    }
    

    vector<int> findOrder(int numCourses, vector<vector<int>>& prereq) {
        vector<int> validOrder;
        // Create an adj list
        vector<int> adj[numCourses];
        for(int i=0;i<prereq.size();i++) {
            adj[prereq[i][1]].push_back(prereq[i][0]);
        }

        // Check if the graph has a cycle
        vector<bool> vis(numCourses, false), path(numCourses, false);
        bool hasCycle = false;
        for(int i=0;i<numCourses;i++) {
            if (vis[i] == false) {
                hasCycle |= dfs_cycle(i, adj, vis, path);
            }
            if(hasCycle) return validOrder;
        }


        // No Cycle found, going ahead with top sort
        deque<int> q;
        for(int i=0;i<numCourses;i++) {
            vis[i] = false;
        }
        for(int i=0;i<numCourses;i++) {
            if(vis[i] == false) {
                dfs_topsort(i, adj, vis, q);
            }
        }
        for(int i=0;i<q.size();i++) {
            validOrder.push_back(q[i]);
        }

        return validOrder;
    }
};
