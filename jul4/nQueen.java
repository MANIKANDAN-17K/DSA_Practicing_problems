class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        int[] col = new int[n];
        int[] LD = new int[n*2];
        int[] RD = new int[n*2];
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        placeQueen(0,col,LD,RD,curr,res);
        return  res;
    }
    private void placeQueen(int i,int[] col,int[] ld,int[] lr,ArrayList<Integer> curr,
    ArrayList<ArrayList<Integer>> res){
        int n = col.length;
        if(i == n){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int j = 0;j<n;j++){
            if(col[j] == 1 || ld[i - j + n - 1] == 1 || lr[j + i] == 1) continue;
            col[j] = 1;
            ld[i - j + n-1] = 1;
            lr[j+i] = 1;
            curr.add(j + 1);
            placeQueen(i + 1,col,ld,lr,curr,res);
            curr.remove(curr.size() - 1);
            col[j] = 0;
            ld[i - j + n - 1] = 0;
            lr[j+i] = 0;
        }
    }
}
