class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        for(int k = 0;k<n;k++){
            for(int j = 0;j<n;j++){
                for(int i = 0;i<n;i++){
                    if(dist[i][k] == 1e8 || dist[k][j] == 1e8) continue;
                    if(dist[i][j] == 1e8) dist[i][j]  = dist[i][k] + dist[k][j];
                    else dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
