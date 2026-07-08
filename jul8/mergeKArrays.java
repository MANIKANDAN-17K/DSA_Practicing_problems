class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        int n = mat.length;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0;i < n;++i){
            if(mat[i].length > 0){
                
            minHeap.add(new int[]{mat[i][0],i,0});
            }
        }
        while(!minHeap.isEmpty()){
            int[] arr = minHeap.poll();
            int val = arr[0];
            int i = arr[1];
            int j = arr[2];
            res.add(val);
            if(j+1 < mat[i].length){
                minHeap.add(new int[]{mat[i][j+1],i,j+1});
            }
        }
        return res;
    }
}
