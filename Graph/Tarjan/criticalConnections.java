class Solution {
    int timer = 0;

    void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
             int[] tin, int[] low, boolean[] vis,
             ArrayList<ArrayList<Integer>> ans) {

        vis[node] = true;
        tin[node] = low[node] = timer++;

        for (int nbr : adj.get(node)) {

            if (nbr == parent) continue;

            if (!vis[nbr]) {
                dfs(nbr, node, adj, tin, low, vis, ans);

                low[node] = Math.min(low[node], low[nbr]);

                if (low[nbr] > tin[node]) {
                    ans.add(new ArrayList<>(Arrays.asList(
                        Math.min(node, nbr),
                        Math.max(node, nbr)
                    )));
                }
            } else {
                low[node] = Math.min(low[node], tin[nbr]);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> criticalConnections(
            int V, ArrayList<ArrayList<Integer>> adj) {

        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < V; i++)
            if (!vis[i])
                dfs(i, -1, adj, tin, low, vis, ans);

        Collections.sort(ans, (a, b) ->
            a.get(0).equals(b.get(0))
                ? a.get(1) - b.get(1)
                : a.get(0) - b.get(0)
        );

        return ans;
    }
}
