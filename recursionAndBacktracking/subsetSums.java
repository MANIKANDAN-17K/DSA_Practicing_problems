class Solution {
    private void helper(int[] a,int i,ArrayList<Integer> res,int curr){
        if(i == a.length){
            res.add(curr);
            return;
        }
        helper(a,i+1,res,curr + a[i]);
        helper(a,i+1,res,curr);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(arr,0,res,0);
        Collections.sort(res);
        return res;
    }
}
