class Solution {
    public void floydWarshall(int[][] dist) {
           int n = dist.length;
           for(int i = 0;i<n;i++){
               for(int j = 0;j<n;j++){
                   for(int k = 0;k<n;k++){
                       if(dist[k][i] != 1e8 && dist[i][j] != 1e8){
                           dist[k][j] = Math.min(dist[k][i] + dist[i][j],dist[k][j]);
                       }
                   }
               }
           }
    }
}

// path builder
